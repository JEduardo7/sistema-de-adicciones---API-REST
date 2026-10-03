package com.sistemaadicciones.backend.repository;

import com.sistemaadicciones.backend.entity.Caso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasoRepository extends JpaRepository<Caso, Long> {
}
