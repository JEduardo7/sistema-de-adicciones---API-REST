package com.sistemaadicciones.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "casos")
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El código del caso es obligatorio")
    @Size(max = 20, message = "El código del caso no puede superar los 20 caracteres")
    @Column(nullable = false, unique = true, length = 20)
    private String codigoCaso;

    @NotNull(message = "La fecha de registro es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaRegistro;

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(max = 100, message = "Los nombres no pueden superar los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 100, message = "Los apellidos no pueden superar los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String apellidos;

    @NotBlank(message = "El documento es obligatorio")
    @Size(max = 12, message = "El documento no puede superar los 12 caracteres")
    @Column(nullable = false, length = 12)
    private String documento;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    @Max(value = 120, message = "La edad no puede superar los 120 años")
    @Column(nullable = false)
    private Integer edad;

    @NotBlank(message = "El sexo es obligatorio")
    @Size(max = 20, message = "El sexo no puede superar los 20 caracteres")
    @Column(nullable = false, length = 20)
    private String sexo;

    @Size(max = 100, message = "La sustancia principal no puede superar los 100 caracteres")
    @Column(length = 100)
    private String sustanciaPrincipal;

    @Size(max = 100, message = "La frecuencia de consumo no puede superar los 100 caracteres")
    @Column(length = 100)
    private String frecuenciaConsumo;

    @Size(max = 100, message = "El tiempo de consumo no puede superar los 100 caracteres")
    @Column(length = 100)
    private String tiempoConsumo;

    @Size(max = 30, message = "El nivel de riesgo no puede superar los 30 caracteres")
    @Column(length = 30)
    private String nivelRiesgo;

    @Size(max = 150, message = "El diagnóstico no puede superar los 150 caracteres")
    @Column(length = 150)
    private String diagnostico;

    @Size(max = 500, message = "Las observaciones no pueden superar los 500 caracteres")
    @Column(length = 500)
    private String observaciones;

    @NotBlank(message = "El estado es obligatorio")
    @Size(max = 30, message = "El estado no puede superar los 30 caracteres")
    @Column(nullable = false, length = 30)
    private String estado;

    @Size(max = 100, message = "El profesional no puede superar los 100 caracteres")
    @Column(length = 100)
    private String profesional;

    public Caso() {
    }

    public Caso(String codigoCaso, LocalDate fechaRegistro, String nombres,
                String apellidos, String documento, Integer edad, String sexo,
                String sustanciaPrincipal, String frecuenciaConsumo,
                String tiempoConsumo, String nivelRiesgo, String diagnostico,
                String observaciones, String estado, String profesional) {
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
