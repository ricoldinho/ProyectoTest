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
        //TODO ACABA ESTO
    }

    

}
