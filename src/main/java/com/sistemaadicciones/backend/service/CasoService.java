package com.sistemaadicciones.backend.service;

import com.sistemaadicciones.backend.entity.Caso;
import com.sistemaadicciones.backend.entity.Seguimiento;
import com.sistemaadicciones.backend.repository.CasoRepository;
import com.sistemaadicciones.backend.repository.SeguimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CasoService {

    private final CasoRepository casoRepository;
    private final SeguimientoRepository seguimientoRepository;

    public CasoService(
            CasoRepository casoRepository,
            SeguimientoRepository seguimientoRepository) {

        this.casoRepository = casoRepository;
        this.seguimientoRepository = seguimientoRepository;
    }

    public List<Caso> listarCasos() {
        return casoRepository.findAll();
    }

    public List<Caso> listarCasosPorProfesional(String profesional) {
        return casoRepository.findAll()
                .stream()
                .filter(caso -> profesional.equals(caso.getProfesional()))
                .toList();
    }

    public Optional<Caso> buscarPorId(Long id) {
        return casoRepository.findById(id);
    }

    public Optional<Caso> buscarPorIdYProfesional(
            Long id,
            String profesional) {

        return casoRepository.findById(id)
                .filter(caso -> profesional.equals(caso.getProfesional()));
    }

    public Caso guardarCaso(Caso caso) {
        return casoRepository.save(caso);
    }

    @Transactional
    public void eliminarCaso(Long id) {

        List<Seguimiento> seguimientos =
                seguimientoRepository.findByCasoId(id);

        if (!seguimientos.isEmpty()) {
            seguimientoRepository.deleteAll(seguimientos);
        }

        casoRepository.deleteById(id);
    }

    public boolean perteneceAProfesional(
            Long id,
            String profesional) {

        return buscarPorIdYProfesional(
                id,
                profesional
        ).isPresent();
    }
}
