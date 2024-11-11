package com.proact.evoflui_backend.controllers;

import com.proact.evoflui_backend.models.Usuario;
import com.proact.evoflui_backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("")
    public List<Usuario> getAllUsers(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

//    @CrossOrigin //Para evitar o erro de CORS
//    @GetMapping("/id/{id}")
//    public List<IndicadosAoOscar> encontrarUmRegistro(){
//        return dbConnection.findIndicadosAoOscarByid();
//    }
}
