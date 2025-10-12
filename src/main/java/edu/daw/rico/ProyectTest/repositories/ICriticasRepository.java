package edu.daw.rico.ProyectTest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.daw.rico.ProyectTest.model.Critica;
import edu.daw.rico.ProyectTest.model.Pelicula;

public interface ICriticasRepository extends JpaRepository<Critica, Long> {

}
