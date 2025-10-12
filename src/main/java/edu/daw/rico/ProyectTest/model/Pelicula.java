package edu.daw.rico.ProyectTest.model;

import java.time.LocalDate;
import java.util.List;

import edu.daw.rico.ProyectTest.model.enums.Genero;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pelicula_id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private int duracion;
    private LocalDate fecha_estreno;
    
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Critica> criticas;

    public Pelicula() {
    }

    public Pelicula(Long pelicula_id, String titulo, Genero genero, int duracion, LocalDate fecha_estreno) {
        this.pelicula_id = pelicula_id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.fecha_estreno = fecha_estreno;
    }

    public Long getId_pelicula() {
        return pelicula_id;
    }

    public void setId_pelicula(Long pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(LocalDate fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public List<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<Critica> criticas) {
        this.criticas = criticas;
    }

    @Override
    public String toString() {
        return "Pelicula [pelicula_id=" + pelicula_id + ", titulo=" + titulo + ", genero=" + genero + ", duracion="
                + duracion + ", fecha_estreno=" + fecha_estreno + "]";
    }

    
    

}
