package com.sistemaadicciones.backend.repository;

import com.sistemaadicciones.backend.entity.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long> {

    List<Seguimiento> findByCasoId(Long casoId);
}
