package com.sistemaadicciones.backend.service;

import com.sistemaadicciones.backend.entity.Caso;
import com.sistemaadicciones.backend.entity.Seguimiento;
import com.sistemaadicciones.backend.repository.CasoRepository;
import com.sistemaadicciones.backend.repository.SeguimientoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SeguimientoService {

    private final SeguimientoRepository seguimientoRepository;
    private final CasoRepository casoRepository;

    public SeguimientoService(SeguimientoRepository seguimientoRepository,
                               CasoRepository casoRepository) {
        this.seguimientoRepository = seguimientoRepository;
        this.casoRepository = casoRepository;
    }

    public List<Seguimiento> listarSeguimientos() {

        if (esAdministrador()) {
            return seguimientoRepository.findAll();
        }

        return seguimientoRepository.findAll()
                .stream()
                .filter(this::tieneAcceso)
                .toList();
    }

    public Optional<Seguimiento> buscarPorId(Long id) {

        Optional<Seguimiento> seguimiento =
                seguimientoRepository.findById(id);

        if (seguimiento.isEmpty() || !tieneAcceso(seguimiento.get())) {
            return Optional.empty();
        }

        return seguimiento;
    }

    public List<Seguimiento> listarPorCasoId(Long casoId) {

        if (!tieneAccesoAlCaso(casoId)) {
            return List.of();
        }

        return seguimientoRepository.findByCasoId(casoId);
    }

    public Seguimiento guardarSeguimiento(Seguimiento seguimiento) {

        if (!tieneAccesoAlCaso(seguimiento.getCasoId())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "No tiene permisos para gestionar este caso"
            );
        }

        seguimiento.setProfesional(usuarioActual());

        return seguimientoRepository.save(seguimiento);
    }

    public void eliminarSeguimiento(Long id) {

        Optional<Seguimiento> seguimiento =
                seguimientoRepository.findById(id);

        if (seguimiento.isPresent() && tieneAcceso(seguimiento.get())) {
            seguimientoRepository.deleteById(id);
        }
    }

    private boolean tieneAcceso(Seguimiento seguimiento) {
        return tieneAccesoAlCaso(seguimiento.getCasoId());
    }

    private boolean tieneAccesoAlCaso(Long casoId) {

        if (esAdministrador()) {
            return true;
        }

        Optional<Caso> caso = casoRepository.findById(casoId);

        return caso.isPresent()
                && usuarioActual().equals(caso.get().getProfesional());
    }

    private boolean esAdministrador() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication != null
                && authentication.getAuthorities()
                .stream()
                .anyMatch(authority ->
                        authority.getAuthority()
                                .equals("ROLE_ADMINISTRADOR")
                );
    }

    private String usuarioActual() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }
}
