package com.proact.evoflui_backend.Controller;

import com.proact.evoflui_backend.DTO.Trilha.TrilhaDTO;
import com.proact.evoflui_backend.DTO.Usuario.UsuarioDTO;
import com.proact.evoflui_backend.DTO.VisualNovel.CenaDTO;
import com.proact.evoflui_backend.DTO.VisualNovel.PersonagemDTO;
import com.proact.evoflui_backend.Model.Novel.Personagem;
import com.proact.evoflui_backend.Model.Trilha.Trilha;
import com.proact.evoflui_backend.Model.Usuario.Usuario;
import com.proact.evoflui_backend.Repository.Cena.PersonagemRepository;
import com.proact.evoflui_backend.Repository.Trilha.TrilhaRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class TrilhaController {

    @Autowired
    private TrilhaRepository trilhaRepository;
    @Autowired
    private PersonagemRepository personagemRepository;

    // METODOS

    private TrilhaDTO convertToDTO(Trilha trilha) {
        return new TrilhaDTO(trilha);
    }

    private List<Long> listToLong(List<CenaDTO> personagens) {
        List<Long> ids = new ArrayList<>();
        for (CenaDTO personagem : personagens) {
            ids.add(personagem.getCenaId());
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

    // ROTAS

    @Transactional
    @RequestMapping("/trilha")
    public ResponseEntity<Object> trilha(HttpSession httpSession) {
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            return ResponseEntity.status(401).build();  // Caso o usuário não esteja logado
        }

        Usuario usuarioRequest = usuarioLogado;
        usuarioRequest.setSenha(null);

        Trilha trilhaUsuario = trilhaRepository.findByTipoTrilha(usuarioLogado.getTipoUsuario());

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
}
