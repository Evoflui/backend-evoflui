package com.proact.evoflui_backend.Controller;

import com.proact.evoflui_backend.DTO.Trilha.TrilhaDTO;
import com.proact.evoflui_backend.DTO.Usuario.UsuarioDTO;
import com.proact.evoflui_backend.DTO.VisualNovel.CenaDTO;
import com.proact.evoflui_backend.DTO.VisualNovel.PersonagemDTO;
import com.proact.evoflui_backend.Model.Novel.Escolha;
import com.proact.evoflui_backend.Model.Novel.Personagem;
import com.proact.evoflui_backend.Model.Trilha.Trilha;
import com.proact.evoflui_backend.Model.Usuario.Usuario;
import com.proact.evoflui_backend.Repository.Cena.PersonagemRepository;
import com.proact.evoflui_backend.Repository.Trilha.TrilhaRepository;
import com.proact.evoflui_backend.Repository.Usuario.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://evoflui-92824.web.app/", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/trilha")  // Definindo /trilha como prefixo para todos os métodos
public class TrilhaController {

    @Autowired
    private TrilhaRepository trilhaRepository;
    @Autowired
    private PersonagemRepository personagemRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Métodos auxiliares

    private TrilhaDTO convertToDTO(Trilha trilha) {
        return new TrilhaDTO(trilha);
    }

    private List<Long> listToLong(List<CenaDTO> personagens) {
        List<Long> ids = new ArrayList<>();
        for (CenaDTO personagem : personagens) {
            ids.add(personagem.getPersonagemCena());
        }
        return ids;
    }

    private List<PersonagemDTO> listIdToPersonagemDTO(List<Long> ids) {
        List<PersonagemDTO> personagemDTOs = new ArrayList<>();
        for (Long id : ids) {
            Personagem personagem = personagemRepository.findById(id).orElse(null);
            if (personagem != null) {
                personagemDTOs.add(new PersonagemDTO(personagem));  // Supondo que PersonagemDTO tenha um construtor que aceite Personagem
            }
        }
        return personagemDTOs;
    }

    // Métodos de mapeamento para rotas específicas

    @GetMapping
    public ResponseEntity<Object> trilha(HttpSession httpSession) {
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            return ResponseEntity.status(401).build();  // Caso o usuário não esteja logado
        }

        Usuario usuarioRequest = usuarioLogado;
        usuarioRequest.setSenha(null);

        Trilha trilhaUsuario = trilhaRepository.findById(Long.valueOf(1)).orElse(null);

        if (trilhaUsuario == null) {
            return ResponseEntity.status(404).build();  // Caso não exista trilha para o tipo de usuário
        }

        TrilhaDTO trilhaDTO = convertToDTO(trilhaUsuario);

        List<CenaDTO> cenaDTO = trilhaDTO.getCenasTrilha();
        List<Long> idPersonagens = listToLong(cenaDTO);
        List<PersonagemDTO> personagensTrilha = listIdToPersonagemDTO(idPersonagens);

        return ResponseEntity.ok(Map.of(
                "usuario", new UsuarioDTO(usuarioRequest),
                "trilha", trilhaDTO,
                "personagens", personagensTrilha
        ));
    }

    @GetMapping("/beginning")
    public ResponseEntity<Void> isNovoFalse(HttpSession httpSession) {
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            return ResponseEntity.status(401).build();
        }

        Optional<Usuario> usuarioBanco = usuarioRepository.findByEmail(usuarioLogado.getEmail());

        if(usuarioBanco.isPresent()) {
            Usuario usuario = usuarioBanco.get();
            usuario.setNovo(false);
            usuarioRepository.save(usuario);

            httpSession.setAttribute("usuarioLogado", usuario);

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(401).build();
    }
}
