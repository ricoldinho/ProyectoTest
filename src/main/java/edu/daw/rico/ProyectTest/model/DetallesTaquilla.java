package edu.daw.rico.ProyectTest.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalles_taquilla")
public class DetallesTaquilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taquilla_id;
    @Column(precision = 15, scale = 2)
    private BigDecimal presupuesto;
    @Column(precision = 15, scale = 2)
    private BigDecimal recaudacion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    public DetallesTaquilla() {
    }

    public Long getTaquilla_id() {
        return taquilla_id;
    }

    public void setTaquilla_id(Long taquilla_id) {
        this.taquilla_id = taquilla_id;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public BigDecimal getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(BigDecimal recaudacion) {
        this.recaudacion = recaudacion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "DetallesTaquilla [taquilla_id=" + taquilla_id + ", presupuesto=" + presupuesto + ", recaudacion="
                + recaudacion + "]";
    }

    
}

