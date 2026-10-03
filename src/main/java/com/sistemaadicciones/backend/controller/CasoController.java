package com.sistemaadicciones.backend.controller;

import com.sistemaadicciones.backend.dto.CasoResponseDTO;
import com.sistemaadicciones.backend.entity.Caso;
import com.sistemaadicciones.backend.service.CasoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/api/casos")
@CrossOrigin(origins = "http://localhost:4200")
public class CasoController {

    private final CasoService casoService;

    public CasoController(CasoService casoService) {
        this.casoService = casoService;
    }

    @GetMapping
    public ResponseEntity<List<CasoResponseDTO>> listarCasos(
            Authentication authentication) {

        List<Caso> casos;

        if (esAdministrador(authentication)) {
            casos = casoService.listarCasos();
        } else {
            casos = casoService.listarCasosPorProfesional(
                    authentication.getName()
            );
        }

        List<CasoResponseDTO> casosResponse = casos
                .stream()
                .map(this::convertirAResponseDTO)
                .toList();

        return ResponseEntity.ok(casosResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoResponseDTO> buscarPorId(
            @PathVariable Long id,
            Authentication authentication) {

        if (esAdministrador(authentication)) {

            return casoService.buscarPorId(id)
                    .map(this::convertirAResponseDTO)
                    .map(ResponseEntity::ok)
                    .orElseGet(() ->
                            ResponseEntity.notFound().build()
                    );
        }

        return casoService
                .buscarPorIdYProfesional(
                        id,
                        authentication.getName()
                )
                .map(this::convertirAResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        casoService.buscarPorId(id).isPresent()
                                ? ResponseEntity.status(403).build()
                                : ResponseEntity.notFound().build()
                );
    }

    @PostMapping
    public ResponseEntity<CasoResponseDTO> guardarCaso(
            @Valid @RequestBody Caso caso,
            Authentication authentication) {

        if (!esAdministrador(authentication)) {
            caso.setProfesional(authentication.getName());
        }

        Caso casoGuardado =
                casoService.guardarCaso(caso);

        return ResponseEntity.ok(
                convertirAResponseDTO(casoGuardado)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasoResponseDTO> actualizarCaso(
            @PathVariable Long id,
            @Valid @RequestBody Caso caso,
            Authentication authentication) {

        if (!esAdministrador(authentication)
                && !casoService.perteneceAProfesional(
                        id,
                        authentication.getName()
                )) {

            return casoService.buscarPorId(id).isPresent()
                    ? ResponseEntity.status(403).build()
                    : ResponseEntity.notFound().build();
        }

        return casoService.buscarPorId(id)
                .map(casoExistente -> {

                    casoExistente.setCodigoCaso(
                            caso.getCodigoCaso()
                    );

                    casoExistente.setFechaRegistro(
                            caso.getFechaRegistro()
                    );

                    casoExistente.setNombres(
                            caso.getNombres()
                    );

                    casoExistente.setApellidos(
                            caso.getApellidos()
                    );

                    casoExistente.setDocumento(
                            caso.getDocumento()
                    );

                    casoExistente.setEdad(
                            caso.getEdad()
                    );

                    casoExistente.setSexo(
                            caso.getSexo()
                    );

                    casoExistente.setSustanciaPrincipal(
                            caso.getSustanciaPrincipal()
                    );

                    casoExistente.setFrecuenciaConsumo(
                            caso.getFrecuenciaConsumo()
                    );

                    casoExistente.setTiempoConsumo(
                            caso.getTiempoConsumo()
                    );

                    casoExistente.setNivelRiesgo(
                            caso.getNivelRiesgo()
                    );

                    casoExistente.setDiagnostico(
                            caso.getDiagnostico()
                    );

                    casoExistente.setObservaciones(
                            caso.getObservaciones()
                    );

                    casoExistente.setEstado(
                            caso.getEstado()
                    );

                    Caso casoActualizado =
                            casoService.guardarCaso(
                                    casoExistente
                            );

                    return ResponseEntity.ok(
                            convertirAResponseDTO(
                                    casoActualizado
                            )
                    );
                })
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCaso(
            @PathVariable Long id,
            Authentication authentication) {

        if (!esAdministrador(authentication)) {
            return ResponseEntity.status(403).build();
        }

        if (casoService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        casoService.eliminarCaso(id);

        return ResponseEntity.noContent().build();
    }

    private boolean esAdministrador(
            Authentication authentication) {

        return authentication
                .getAuthorities()
                .stream()
                .anyMatch(authority ->
                        "ROLE_ADMINISTRADOR"
                                .equals(authority.getAuthority())
                );
    }

    private CasoResponseDTO convertirAResponseDTO(Caso caso) {

        return new CasoResponseDTO(
                caso.getId(),
                caso.getCodigoCaso(),
                caso.getFechaRegistro(),
                caso.getNombres(),
                caso.getApellidos(),
                caso.getDocumento(),
                caso.getEdad(),
                caso.getSexo(),
                caso.getSustanciaPrincipal(),
                caso.getFrecuenciaConsumo(),
                caso.getTiempoConsumo(),
                caso.getNivelRiesgo(),
                caso.getDiagnostico(),
                caso.getObservaciones(),
                caso.getEstado(),
                caso.getProfesional()
        );
    }
}
