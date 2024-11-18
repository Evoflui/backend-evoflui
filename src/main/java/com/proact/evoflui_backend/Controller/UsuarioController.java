package com.proact.evoflui_backend.Controller;

import com.proact.evoflui_backend.Model.Novel.Personagem;
import com.proact.evoflui_backend.Model.Novel.RelacionamentoUsuarioPersonagem;
import com.proact.evoflui_backend.Model.Trilha.Trilha;
import com.proact.evoflui_backend.Repository.Cena.PersonagemRepository;
import com.proact.evoflui_backend.Repository.Cena.RelacionamentoUsuarioPersonagemRepository;
import com.proact.evoflui_backend.Repository.Trilha.TrilhaRepository;
import com.proact.evoflui_backend.Model.Usuario.Usuario;
import com.proact.evoflui_backend.Repository.Usuario.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TrilhaRepository trilhaRepository;
    @Autowired
    private RelacionamentoUsuarioPersonagemRepository relacionamentoUsuarioPersonagemRepository;
    @Autowired
    private PersonagemRepository personagemRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 200 - OK
    // 201 - ELEMENTO SALVO NO BANCO DE DADOS
    // 204 - SEM CONTEUDO
    // 409 - ELEMENTO JÀ EXISTE
    // 401 - ELEMENTO NÂO EXISTE
    // 403 - SENHA INCORRETA

    @RequestMapping("/cadastro")
    public ResponseEntity<Void> requestCadastro(HttpSession httpSession) {
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        if (usuarioLogado != null) {
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(200).build();
    }

    public List<RelacionamentoUsuarioPersonagem> salvarRelacionamentoPersonsagens(Usuario usuario) {
        List<Personagem> personagens = personagemRepository.findAll();
        List<RelacionamentoUsuarioPersonagem> listaRelacionamentos = new ArrayList<>();

        for (Personagem personagem : personagens) {
            RelacionamentoUsuarioPersonagem novoRelacionamento = new RelacionamentoUsuarioPersonagem(
                    personagem.getPersonagemId(),
                    usuario
            );
            listaRelacionamentos.add(novoRelacionamento);
        }

        return listaRelacionamentos;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioEncontrado.isPresent()) {
            return ResponseEntity.status(409).build();
        }
        String senhaHash = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaHash);
        usuarioRepository.save(usuario);

        List<RelacionamentoUsuarioPersonagem> relacionamentosUsuario = salvarRelacionamentoPersonsagens(usuario);
        usuario.setRelacionamentosUsuario(relacionamentosUsuario);

        relacionamentoUsuarioPersonagemRepository.saveAll(relacionamentosUsuario);

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
            return ResponseEntity.status(401).build();
        }

        Usuario usuarioSemDadosSensiveis = new Usuario(
                usuarioLogado.getNome(),
                usuarioLogado.getEmail(),
                usuarioLogado.getApelido(),
                null,
                usuarioLogado.getTipoUsuario(),
                usuarioLogado.getProgressoTrilha(),
                usuarioLogado.getRelacionamentosUsuario(),
                usuarioLogado.getStatusUsuario()
        );

        Optional<Trilha> trilhaUsuarioEncontrada = trilhaRepository.findById(usuarioLogado.getTipoUsuario());
        if(trilhaUsuarioEncontrada.isPresent()) {
            Trilha trilhaUsuario = trilhaUsuarioEncontrada.get();
        }

        return ResponseEntity.ok(usuarioSemDadosSensiveis);
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
