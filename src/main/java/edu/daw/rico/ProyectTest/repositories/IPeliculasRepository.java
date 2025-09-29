package edu.daw.rico.ProyectTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.daw.rico.ProyectTest.model.Pelicula;

public interface IPeliculasRepository extends JpaRepository<Pelicula, Long> {

}
