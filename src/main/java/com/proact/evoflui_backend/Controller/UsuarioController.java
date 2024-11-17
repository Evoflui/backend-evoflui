package com.proact.evoflui_backend.Controller;

import com.proact.evoflui_backend.Model.Usuario.TipoUsuario;
import com.proact.evoflui_backend.Repository.Usuario.TipoUsuarioRepository;
import com.proact.evoflui_backend.Model.Usuario.Usuario;
import com.proact.evoflui_backend.Repository.Usuario.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    //Segurança em senhas, por criptografia
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    @Autowired
//    private TipoUsuarioRepository tipoUsuarioRepository;
//    @RequestMapping("/cadastro")
//    public List<TipoUsuario> requestCadastro() {
//        return tipoUsuarioRepository.findAll();
//    }

    // 200 - OK
    // 201 - ELEMENTO SALVO NO BANCO DE DADOS
    // 204 - SEM CONTEUDO
    // 409 - ELEMENTO JÀ EXISTE
    // 401 - ELEMENTO NÂO EXISTE
    // 403 - SENHA INCORRETA

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody Usuario usuario) {
        System.out.println(usuario.getTipoUsuario());
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioEncontrado.isPresent()) {
            return ResponseEntity.status(409).build();
        }
        String senhaHash = passwordEncoder.encode(usuario.getSenha()); //pega a senha do usuario, e transforma em hash
        usuario.setSenha(senhaHash); // seta a senha do usuario sendo ela uma hash
        usuarioRepository.save(usuario); // manda pro BD o usuario
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/home")
    public ResponseEntity<Void> loginUsuario(@RequestBody Usuario usuario, HttpSession httpSession) {
        if (usuario.getEmail() == null || usuario.getSenha() == null) {
            return ResponseEntity.badRequest().build(); // 400
        }

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());

        if(usuarioEncontrado.isPresent()) {
            if (passwordEncoder.matches(usuario.getSenha(), usuarioEncontrado.get().getSenha())) {
                Usuario usuarioLogado = usuarioEncontrado.get();
                httpSession.setAttribute("usuarioId", usuarioLogado.getUsuarioId());
                httpSession.setAttribute("usuarioLogado", usuarioLogado);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(403).build(); // Senha incorreta
            }
        } else {
            return ResponseEntity.status(401).build(); // Usuário não encontrado
        }
    }

    @RequestMapping("/home")
    public ResponseEntity<Usuario> home(HttpSession httpSession) {
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            // Retorna uma resposta 401 (Unauthorized) caso o usuário não esteja logado
            return ResponseEntity.status(401).build();
        }

        Usuario usuarioSemDadosSensiveis = new Usuario(usuarioLogado.getUsuarioId());
        usuarioSemDadosSensiveis.setNome(usuarioLogado.getNome());
        usuarioSemDadosSensiveis.setEmail(usuarioLogado.getEmail());
        usuarioSemDadosSensiveis.setTipoUsuario(usuarioLogado.getTipoUsuario());
        usuarioSemDadosSensiveis.setProgressoTrilha(usuarioLogado.getProgressoTrilha());
        usuarioSemDadosSensiveis.setStatusUsuario(usuarioLogado.getStatusUsuario());

        return ResponseEntity.ok(usuarioSemDadosSensiveis);
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
