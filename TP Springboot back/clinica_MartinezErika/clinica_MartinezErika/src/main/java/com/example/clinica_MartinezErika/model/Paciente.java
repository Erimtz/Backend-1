package com.example.clinica_MartinezErika.model;


public class Paciente {
    //Atributos
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private Domicilio domicilio;

    public Paciente() {
    }

    public Paciente(Integer id, String nombre, String apellido, String email, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.domicilio = domicilio;
    }

    public Paciente(String nombre, String apellido, String email, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.domicilio = domicilio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", domicilio=" + domicilio +
                '}';
    }

}
