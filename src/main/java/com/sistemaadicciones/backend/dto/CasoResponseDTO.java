package com.sistemaadicciones.backend.dto;

import java.time.LocalDate;

public class CasoResponseDTO {

    private Long id;
    private String codigoCaso;
    private LocalDate fechaRegistro;
    private String nombres;
    private String apellidos;
    private String documento;
    private Integer edad;
    private String sexo;
    private String sustanciaPrincipal;
    private String frecuenciaConsumo;
    private String tiempoConsumo;
    private String nivelRiesgo;
    private String diagnostico;
    private String observaciones;
    private String estado;
    private String profesional;

    public CasoResponseDTO() {
    }

    public CasoResponseDTO(Long id, String codigoCaso, LocalDate fechaRegistro,
                           String nombres, String apellidos, String documento,
                           Integer edad, String sexo, String sustanciaPrincipal,
                           String frecuenciaConsumo, String tiempoConsumo,
                           String nivelRiesgo, String diagnostico,
                           String observaciones, String estado,
                           String profesional) {
        this.id = id;
        this.codigoCaso = codigoCaso;
        this.fechaRegistro = fechaRegistro;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.edad = edad;
        this.sexo = sexo;
        this.sustanciaPrincipal = sustanciaPrincipal;
        this.frecuenciaConsumo = frecuenciaConsumo;
        this.tiempoConsumo = tiempoConsumo;
        this.nivelRiesgo = nivelRiesgo;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
        this.estado = estado;
        this.profesional = profesional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoCaso() {
        return codigoCaso;
    }

    public void setCodigoCaso(String codigoCaso) {
        this.codigoCaso = codigoCaso;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSustanciaPrincipal() {
        return sustanciaPrincipal;
    }

    public void setSustanciaPrincipal(String sustanciaPrincipal) {
        this.sustanciaPrincipal = sustanciaPrincipal;
    }

    public String getFrecuenciaConsumo() {
        return frecuenciaConsumo;
    }

    public void setFrecuenciaConsumo(String frecuenciaConsumo) {
        this.frecuenciaConsumo = frecuenciaConsumo;
    }

    public String getTiempoConsumo() {
        return tiempoConsumo;
    }

    public void setTiempoConsumo(String tiempoConsumo) {
        this.tiempoConsumo = tiempoConsumo;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }
}
