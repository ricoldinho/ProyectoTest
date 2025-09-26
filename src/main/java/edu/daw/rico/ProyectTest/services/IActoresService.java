package edu.daw.rico.ProyectTest.services;

import java.util.List;

import edu.daw.rico.ProyectTest.model.Actor;

public interface IActoresService {

    public List<Actor> listarActores();
    public void eliminarActorPorId(Long id);
}
