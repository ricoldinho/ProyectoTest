package edu.daw.rico.ProyectTest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.daw.rico.ProyectTest.model.Pelicula;
import edu.daw.rico.ProyectTest.repositories.IPeliculasRepository;

@Service
public class PeliculasService implements IPeliculasService {

    @Autowired
    private IPeliculasRepository peliculasRepo;

    public List<Pelicula> listarPeliculas() {
       
        if(peliculasRepo.findAll().isEmpty()){
            System.err.println("LA TABLA PELÍCULAS ESTÁ VACÍA");
            return null;
        }
        return peliculasRepo.findAll();
       
    }

}
