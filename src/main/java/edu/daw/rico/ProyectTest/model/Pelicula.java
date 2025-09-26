package edu.daw.rico.ProyectTest.model;

import java.time.LocalDate;

import edu.daw.rico.ProyectTest.model.enums.Genero;

public class Pelicula {
    private Long id_pelicula;
    private String titulo;
    private Genero genero;
    private int duracion;
    private LocalDate fecha_estreno;

    public Pelicula() {
    }

    public Pelicula(Long id_pelicula, String titulo, Genero genero, int duracion, LocalDate fecha_estreno) {
        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.fecha_estreno = fecha_estreno;
    }

    public Long getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Long id_pelicula) {
        this.id_pelicula = id_pelicula;
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

    @Override
    public String toString() {
        return "Pelicula [id_pelicula=" + id_pelicula + ", titulo=" + titulo + ", genero=" + genero + ", duracion="
                + duracion + ", fecha_estreno=" + fecha_estreno + "]";
    }

    

}
