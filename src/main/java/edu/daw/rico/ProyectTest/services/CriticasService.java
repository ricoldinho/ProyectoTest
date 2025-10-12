package edu.daw.rico.ProyectTest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.daw.rico.ProyectTest.model.Critica;
import edu.daw.rico.ProyectTest.repositories.ICriticasRepository;

@Service
public class CriticasService implements ICriticasService{

    @Autowired
    private ICriticasRepository criticasRepo;

    @Override
    public List<Critica> listarCriticas() {
        return criticasRepo.findAll();
    }


}
