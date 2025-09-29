package edu.daw.rico.ProyectTest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.daw.rico.ProyectTest.model.Actor;
import edu.daw.rico.ProyectTest.repositories.IActoresRepository;

@Service
public class ActoresService implements IActoresService {

    @Autowired
    private IActoresRepository actoresRepo;

    @Override
    public List<Actor> listarActores() {
        return actoresRepo.findAll();
    }

    @Override
    public void eliminarActorPorId(Long id) {
        actoresRepo.deleteById(id);
    }

    @Override
    public Actor listarActorPorId(Long id) {
        return actoresRepo.findById(id).orElse(null);
    }

    @Override
    public Actor modificarPorId(Actor actor) {
        if (actoresRepo.existsById(actor.getId_actor())) {
            return actoresRepo.save(actor);
        }else{
            System.err.println("El actor con ID " + actor.getId_actor() + " no existe o no puede ser modificado.");
            return null;
        }
    }

    @Override
    public Actor insertarActor(Actor actor) {
        return actoresRepo.save(actor);
    }

    

}
