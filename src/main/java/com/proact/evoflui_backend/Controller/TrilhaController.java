package com.proact.evoflui_backend.Controller;

import com.proact.evoflui_backend.Model.Usuario.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class TrilhaController {

    @RequestMapping("/trilha")
    public ResponseEntity<Usuario> trilha(HttpSession httpSession) {
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            return ResponseEntity.status(401).build();
        }

        Usuario usuarioSemDadosSensiveis = new Usuario();
        usuarioSemDadosSensiveis.setNome(usuarioLogado.getNome());
        usuarioSemDadosSensiveis.setEmail(usuarioLogado.getEmail());
        usuarioSemDadosSensiveis.setTipoUsuario(usuarioLogado.getTipoUsuario());
        usuarioSemDadosSensiveis.setProgressoTrilha(usuarioLogado.getProgressoTrilha());
        usuarioSemDadosSensiveis.setStatusUsuario(usuarioLogado.getStatusUsuario());

        // Pegando dados da trilha do user

        return ResponseEntity.status(401).build();
    }
}
