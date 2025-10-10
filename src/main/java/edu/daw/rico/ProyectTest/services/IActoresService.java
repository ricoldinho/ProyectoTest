package edu.daw.rico.ProyectTest.services;

import java.util.List;

import edu.daw.rico.ProyectTest.model.Actor;

public interface IActoresService {

    public List<Actor> listarActoresConPeliculas();
    public List<Actor> listarActores();
    public Actor listarActorPorId(Long id);
    public Actor modificarPorId(Actor actor);
    public Actor insertarActor(Actor actor);
    public void eliminarActorPorId(Long id);
}
