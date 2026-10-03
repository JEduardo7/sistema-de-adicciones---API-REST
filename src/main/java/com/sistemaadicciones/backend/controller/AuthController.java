package com.sistemaadicciones.backend.controller;

import com.sistemaadicciones.backend.config.JwtService;
import com.sistemaadicciones.backend.dto.LoginRequestDTO;
import com.sistemaadicciones.backend.entity.Usuario;
import com.sistemaadicciones.backend.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    public AuthController(
            AuthenticationManager authenticationManager,
            UsuarioRepository usuarioRepository,
            JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        Usuario usuario = usuarioRepository
                .findByUsername(authentication.getName())
                .orElseThrow();

        String token = jwtService.generarToken(
                usuario.getUsername(),
                usuario.getRol()
        );

        return ResponseEntity.ok(
                Map.of(
                        "mensaje", "Inicio de sesión correcto",
                        "username", usuario.getUsername(),
                        "rol", usuario.getRol(),
                        "token", token
                )
        );
    }
}

