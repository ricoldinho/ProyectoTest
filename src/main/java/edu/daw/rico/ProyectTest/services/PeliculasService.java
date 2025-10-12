package edu.daw.rico.ProyectTest.services;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void eliminarPeliculaPorId(Long id) {
        peliculasRepo.deleteById(id);
    }

    @Override
    public Pelicula listarPeliculaPorId(Long id) {
       return peliculasRepo.findById(id).orElse(null);
    }

    @Override
    public Pelicula modificarPorId(Pelicula pelicula) {
        if (peliculasRepo.existsById(pelicula.getId_pelicula())) {
            return peliculasRepo.save(pelicula);
        }else{
            System.err.println("La película con ID " + pelicula.getId_pelicula() + " no existe o no puede ser modificada.");
            return null;
        }
    }

    @Override
    public Pelicula insertarPelicula(Pelicula pelicula) {
        return peliculasRepo.save(pelicula);
    }

    @Override
    public List<Pelicula> listarPeliculasConCriticas() {
        return peliculasRepo.findAllConCriticas();
    }

    @Override
    public Pelicula listarPeliculaPorIdConCritica(Long id) {
        Optional<Pelicula> op = peliculasRepo.findByIdConCriticas(id);
            if (op != null) {
                return op.get();
            }
        System.out.println("ERROR EN BÚSQUEDA");
        return null;
    }

}
