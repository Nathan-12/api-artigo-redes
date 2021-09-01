package com.rfid.education.controller;

import com.rfid.education.model.Usuario;
import com.rfid.education.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/{name}")
    public Usuario adicionarUsuario(@PathVariable("name") String name) {
        Usuario novo = new Usuario();
        novo.setNome(name);
        return usuarioRepository.save(novo);
    }
}
