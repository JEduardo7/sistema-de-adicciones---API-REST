package com.sistemaadicciones.backend.controller;

import com.sistemaadicciones.backend.dto.SeguimientoResponseDTO;
import com.sistemaadicciones.backend.entity.Seguimiento;
import com.sistemaadicciones.backend.service.SeguimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seguimientos")
@CrossOrigin(origins = "http://localhost:4200")
public class SeguimientoController {

    private final SeguimientoService seguimientoService;

    public SeguimientoController(SeguimientoService seguimientoService) {
        this.seguimientoService = seguimientoService;
    }

    @GetMapping
    public ResponseEntity<List<SeguimientoResponseDTO>> listarSeguimientos() {
        List<SeguimientoResponseDTO> seguimientos = seguimientoService.listarSeguimientos()
                .stream()
                .map(this::convertirAResponseDTO)
                .toList();

        return ResponseEntity.ok(seguimientos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguimientoResponseDTO> buscarPorId(@PathVariable Long id) {
        return seguimientoService.buscarPorId(id)
                .map(this::convertirAResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/caso/{casoId}")
    public ResponseEntity<List<SeguimientoResponseDTO>> listarPorCasoId(
            @PathVariable Long casoId) {

        List<SeguimientoResponseDTO> seguimientos = seguimientoService.listarPorCasoId(casoId)
                .stream()
                .map(this::convertirAResponseDTO)
                .toList();

        return ResponseEntity.ok(seguimientos);
    }

    @PostMapping
    public ResponseEntity<SeguimientoResponseDTO> guardarSeguimiento(
            @RequestBody Seguimiento seguimiento) {

        Seguimiento seguimientoGuardado =
                seguimientoService.guardarSeguimiento(seguimiento);

        return ResponseEntity.ok(convertirAResponseDTO(seguimientoGuardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguimientoResponseDTO> actualizarSeguimiento(
            @PathVariable Long id,
            @RequestBody Seguimiento seguimiento) {

        return seguimientoService.buscarPorId(id)
                .map(seguimientoExistente -> {
                    seguimientoExistente.setCasoId(seguimiento.getCasoId());
                    seguimientoExistente.setFechaSeguimiento(
                            seguimiento.getFechaSeguimiento()
                    );
                    seguimientoExistente.setProfesional(
                            seguimiento.getProfesional()
                    );
                    seguimientoExistente.setTipoSeguimiento(
                            seguimiento.getTipoSeguimiento()
                    );
                    seguimientoExistente.setDescripcion(
                            seguimiento.getDescripcion()
                    );
                    seguimientoExistente.setAcuerdos(
                            seguimiento.getAcuerdos()
                    );
                    seguimientoExistente.setResultado(
                            seguimiento.getResultado()
                    );

                    Seguimiento seguimientoActualizado =
                            seguimientoService.guardarSeguimiento(
                                    seguimientoExistente
                            );

                    return ResponseEntity.ok(
                            convertirAResponseDTO(seguimientoActualizado)
                    );
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSeguimiento(
            @PathVariable Long id) {

        return seguimientoService.buscarPorId(id)
                .map(seguimiento -> {
                    seguimientoService.eliminarSeguimiento(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private SeguimientoResponseDTO convertirAResponseDTO(
            Seguimiento seguimiento) {

        return new SeguimientoResponseDTO(
                seguimiento.getId(),
                seguimiento.getCasoId(),
                seguimiento.getFechaSeguimiento(),
                seguimiento.getProfesional(),
                seguimiento.getTipoSeguimiento(),
                seguimiento.getDescripcion(),
                seguimiento.getAcuerdos(),
                seguimiento.getResultado()
        );
    }
}

