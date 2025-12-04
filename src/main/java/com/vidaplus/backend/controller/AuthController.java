package com.vidaplus.backend.controller;

import com.vidaplus.backend.model.Usuario;
import com.vidaplus.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar usuário (Cadastro)
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email já cadastrado.");
        }

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário criado com sucesso!");
    }

    // Login simples (sem JWT)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Usuario userDB = usuarioRepository.findByEmail(usuario.getEmail());

        if (userDB == null || !userDB.getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.badRequest().body("Credenciais inválidas.");
        }

        return ResponseEntity.ok("Login realizado com sucesso!");
    }
}
