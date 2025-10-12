package edu.daw.rico.ProyectTest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.daw.rico.ProyectTest.model.Pelicula;

public interface IPeliculasRepository extends JpaRepository<Pelicula, Long> {
      // Trae todas las películas con sus críticas inicializadas
    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN FETCH p.criticas")
    List<Pelicula> findAllConCriticas();

    // Trae una película por ID con sus críticas inicializadas
    @Query("SELECT p FROM Pelicula p LEFT JOIN FETCH p.criticas WHERE p.pelicula_id = :id")
    Optional<Pelicula> findByIdConCriticas(Long id);

}
