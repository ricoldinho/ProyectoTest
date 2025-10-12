package edu.daw.rico.ProyectTest.model;

import java.time.LocalDate;

import edu.daw.rico.ProyectTest.model.enums.Valoracion;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "criticas")
public class Critica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long critica_id;
    private LocalDate fecha;
    private String autor;
    //No ponemos Enumerated porque hemos definido un Converter
    private Valoracion valoracion;
    private String comentario;

    // --- RELACIÓN INVERSA (ManyToOne) ---
    // Muchas críticas pueden pertenecer a Una película
    @ManyToOne
    @JoinColumn(name = "pelicula_id", nullable = false)
    private Pelicula pelicula;

    
    
    public Critica() {
    }

    

    public Long getCritica_id() {
        return critica_id;
    }



    public void setCritica_id(Long critica_id) {
        this.critica_id = critica_id;
    }



    public LocalDate getFecha() {
        return fecha;
    }



    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }



    public String getAutor() {
        return autor;
    }



    public void setAutor(String autor) {
        this.autor = autor;
    }



    public Valoracion getValoracion() {
        return valoracion;
    }



    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }



    public String getComentario() {
        return comentario;
    }



    public void setComentario(String comentario) {
        this.comentario = comentario;
    }



    public Pelicula getPelicula() {
        return pelicula;
    }



    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }



    @Override
    public String toString() {
        return "Critica [critica_id=" + critica_id + ", fecha=" + fecha + ", autor=" + autor + ", valoracion="
                + valoracion + ", comentario=" + comentario + "]";
    }



   
}