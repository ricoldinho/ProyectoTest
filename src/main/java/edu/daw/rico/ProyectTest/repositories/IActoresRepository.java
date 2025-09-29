package edu.daw.rico.ProyectTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.daw.rico.ProyectTest.model.Actor;

public interface IActoresRepository extends JpaRepository<Actor, Long> {
    
}
