package edu.daw.rico.ProyectTest.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "actores")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actor_id;
    private String nombre;
    private String apellido;    
    private LocalDate fecha_nacimiento;
    private boolean oscarizado;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "actores_peliculas",
        joinColumns = @JoinColumn(name = "actor_id") ,
        inverseJoinColumns = @JoinColumn(name = "pelicula_id") )
    private Set<Pelicula> peliculas = new HashSet<Pelicula>() {
        
    };



    public Actor() {
    }

    

    public Actor(String nombre, String apellido, LocalDate fecha_nacimiento, boolean oscarizado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.oscarizado = oscarizado;
    }



    public Actor(Long actor_id, String nombre, String apellido, LocalDate fecha_nacimiento, boolean oscarizado) {
        this.actor_id = actor_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.oscarizado = oscarizado;
    }

    public Long getId_actor() {
        return actor_id;
    }

    public void setId_actor(Long id_actor) {
        this.actor_id = id_actor;
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

    
    public Long getActor_id() {
        return actor_id;
    }



    public void setActor_id(Long actor_id) {
        this.actor_id = actor_id;
    }



    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }



    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }



    @Override
    public String toString() {
        return "Actor [actor_id=" + actor_id + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nacimiento="
                + fecha_nacimiento + ", oscarizado=" + oscarizado + "]";
    }



   

    
}
