package edu.daw.rico.ProyectTest.services;

import java.util.List;

import edu.daw.rico.ProyectTest.model.Critica;
import edu.daw.rico.ProyectTest.model.Pelicula;

public interface IPeliculasService {
    public List<Pelicula> listarPeliculas();
    public void eliminarPeliculaPorId(Long id);
    public Pelicula listarPeliculaPorId(Long id);
    public Pelicula modificarPorId(Pelicula pelicula);
    public Pelicula insertarPelicula(Pelicula pelicula);
    public List<Pelicula> listarPeliculasConCriticas();
    public Pelicula listarPeliculaPorIdConCritica(Long id);
}
