package com.sistemaadicciones.backend.dto;

import java.time.LocalDate;

public class SeguimientoResponseDTO {

    private Long id;
    private Long casoId;
    private LocalDate fechaSeguimiento;
    private String profesional;
    private String tipoSeguimiento;
    private String descripcion;
    private String acuerdos;
    private String resultado;

    public SeguimientoResponseDTO() {
    }

    public SeguimientoResponseDTO(Long id, Long casoId,
                                  LocalDate fechaSeguimiento,
                                  String profesional,
                                  String tipoSeguimiento,
                                  String descripcion,
                                  String acuerdos,
                                  String resultado) {
        this.id = id;
        this.casoId = casoId;
        this.fechaSeguimiento = fechaSeguimiento;
        this.profesional = profesional;
        this.tipoSeguimiento = tipoSeguimiento;
        this.descripcion = descripcion;
        this.acuerdos = acuerdos;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCasoId() {
        return casoId;
    }

    public void setCasoId(Long casoId) {
        this.casoId = casoId;
    }

    public LocalDate getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(LocalDate fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    public String getTipoSeguimiento() {
        return tipoSeguimiento;
    }

    public void setTipoSeguimiento(String tipoSeguimiento) {
        this.tipoSeguimiento = tipoSeguimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAcuerdos() {
        return acuerdos;
    }

    public void setAcuerdos(String acuerdos) {
        this.acuerdos = acuerdos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
