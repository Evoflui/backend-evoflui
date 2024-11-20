package com.proact.evoflui_backend.Controller;

import com.proact.evoflui_backend.DTO.Trilha.TrilhaDTO;
import com.proact.evoflui_backend.DTO.Usuario.UsuarioDTO;
import com.proact.evoflui_backend.Model.Trilha.Trilha;
import com.proact.evoflui_backend.Model.Usuario.Usuario;
import com.proact.evoflui_backend.Repository.Trilha.TrilhaRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class TrilhaController {

    @Autowired
    private TrilhaRepository trilhaRepository;

    // METODOS

    private TrilhaDTO convertToDTO(Trilha trilha) {
        return new TrilhaDTO(trilha);
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

        return ResponseEntity.ok(Map.of(
                "usuario", new UsuarioDTO(usuarioRequest),
                "trilha", trilhaDTO
        ));
    }
}
