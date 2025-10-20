package edu.daw.rico.ProyectTest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.daw.rico.ProyectTest.model.DetallesTaquilla;
import edu.daw.rico.ProyectTest.repositories.IDetallesTaquillasRepository;

@Service
public class DetallesTaquillaService implements IDetallesTaquillaService {

    @Autowired
    private IDetallesTaquillasRepository detallesTaquillasRepo;

    @Override
    public List<DetallesTaquilla> listarDetallesTaquilla() {
       return detallesTaquillasRepo.findAll();
    }
}
