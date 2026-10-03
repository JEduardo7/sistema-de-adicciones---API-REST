package com.sistemaadicciones.backend.controller;

import com.sistemaadicciones.backend.dto.UsuarioResponseDTO;
import com.sistemaadicciones.backend.entity.Usuario;
import com.sistemaadicciones.backend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        List<UsuarioResponseDTO> usuarios = usuarioService.listarUsuarios()
                .stream()
                .map(this::convertirAResponseDTO)
                .toList();

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(this::convertirAResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);

        return ResponseEntity.ok(convertirAResponseDTO(usuarioGuardado));
    }

    private UsuarioResponseDTO convertirAResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getUsername(),
                usuario.getRol(),
                usuario.getEstado()
        );
    }
}