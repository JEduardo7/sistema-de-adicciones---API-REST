package com.sistemaadicciones.backend.dto;

public class UsuarioResponseDTO {

    private Long id;
    private String nombres;
    private String apellidos;
    private String username;
    private String rol;
    private Boolean estado;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nombres, String apellidos,
                              String username, String rol, Boolean estado) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.rol = rol;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}