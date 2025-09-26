package edu.daw.rico.ProyectTest.model;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "actores")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_actor;
    private String nombre;
    private String apellido;    
    private LocalDate fecha_nacimiento;
    private boolean oscarizado;

    public Actor() {
    }

    public Actor(Long id_actor, String nombre, String apellido, LocalDate fecha_nacimiento, boolean oscarizado) {
        this.id_actor = id_actor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.oscarizado = oscarizado;
    }

    public Long getId_actor() {
        return id_actor;
    }

    public void setId_actor(Long id_actor) {
        this.id_actor = id_actor;
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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isOscarizado() {
        return oscarizado;
    }

    public void setOscarizado(boolean oscarizado) {
        this.oscarizado = oscarizado;
    }

    @Override
    public String toString() {
        return "Actor [id_actor=" + id_actor + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nacimiento="
                + fecha_nacimiento + ", oscarizado=" + oscarizado + "]";
    }

    
}
