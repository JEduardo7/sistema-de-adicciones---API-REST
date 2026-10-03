package com.sistemaadicciones.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "seguimientos")
public class Seguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long casoId;

    @Column(nullable = false)
    private LocalDate fechaSeguimiento;

    @Column(nullable = false, length = 100)
    private String profesional;

    @Column(nullable = false, length = 30)
    private String tipoSeguimiento;

    @Column(length = 500)
    private String descripcion;

    @Column(length = 500)
    private String acuerdos;

    @Column(length = 30)
    private String resultado;

    public Seguimiento() {
    }

    public Seguimiento(Long casoId, LocalDate fechaSeguimiento,
                        String profesional, String tipoSeguimiento,
                        String descripcion, String acuerdos,
                        String resultado) {
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
