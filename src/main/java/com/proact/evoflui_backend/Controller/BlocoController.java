package com.proact.evoflui_backend.Controller;

import com.proact.evoflui_backend.DTO.Trilha.BlocoDTO;
import com.proact.evoflui_backend.DTO.Trilha.TrilhaDTO;
import com.proact.evoflui_backend.DTO.Usuario.UsuarioDTO;
import com.proact.evoflui_backend.DTO.VisualNovel.CenaDTO;
import com.proact.evoflui_backend.DTO.VisualNovel.PersonagemDTO;
import com.proact.evoflui_backend.Model.Novel.Personagem;
import com.proact.evoflui_backend.Model.Trilha.Trilha;
import com.proact.evoflui_backend.Model.Usuario.Usuario;
import com.proact.evoflui_backend.Repository.Cena.PersonagemRepository;
import com.proact.evoflui_backend.Repository.Trilha.TrilhaRepository;
import com.proact.evoflui_backend.Repository.Usuario.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "https://evoflui-92824.web.app/", allowedHeaders = "*", allowCredentials = "true")
public class BlocoController {
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

    @GetMapping("/comunicacao-cenas")
    public ResponseEntity<Object> blocoComunicacao(HttpSession httpSession) {
        return handleBlocoRequest(httpSession, 0); // Índice 0 para Comunicação
    }

    @GetMapping("/sensorial-cenas")
    public ResponseEntity<Object> blocoSensorial(HttpSession httpSession) {
        return handleBlocoRequest(httpSession, 1); // Índice 1 para Sensorial
    }

    @GetMapping("/adaptacao-cenas")
    public ResponseEntity<Object> blocoAdaptacao(HttpSession httpSession) {
        return handleBlocoRequest(httpSession, 2); // Índice 2 para Adaptação
    }

    @GetMapping("/decisao-cenas")
    public ResponseEntity<Object> blocoDecisao(HttpSession httpSession) {
        return handleBlocoRequest(httpSession, 3); // Índice 3 para Decisão
    }

    private ResponseEntity<Object> handleBlocoRequest(HttpSession httpSession, int blocoIndex) {
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            return ResponseEntity.status(401).build(); // Usuário não logado
        }

        Usuario usuarioRequest = usuarioLogado;
        usuarioRequest.setSenha(null);

        Trilha trilhaUsuario = trilhaRepository.findById(Long.valueOf(1)).orElse(null);

        if (trilhaUsuario == null) {
            return ResponseEntity.status(404).build(); // Trilha não encontrada para o tipo de usuário
        }

        TrilhaDTO trilhaDTO = convertToDTO(trilhaUsuario);
        List<BlocoDTO> blocoTrilha = trilhaDTO.getBlocosTrilha();

        if (blocoIndex >= blocoTrilha.size()) {
            return ResponseEntity.status(400).body("Índice do bloco inválido");
        }

        BlocoDTO blocoSelecionado = blocoTrilha.get(blocoIndex);

        List<CenaDTO> cenasDTO = blocoSelecionado.getCenasBloco();
        System.out.println(blocoSelecionado.getCenasBloco());
        List<Long> idPersonagens = listToLong(cenasDTO);
        List<PersonagemDTO> personagensTrilha = listIdToPersonagemDTO(idPersonagens);

        return ResponseEntity.ok(Map.of(
                "usuario", new UsuarioDTO(usuarioRequest),
                "cenas", cenasDTO,
                "personagens", personagensTrilha
        ));
    }

}
