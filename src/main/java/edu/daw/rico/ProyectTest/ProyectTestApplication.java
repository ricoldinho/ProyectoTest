package edu.daw.rico.ProyectTest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.daw.rico.ProyectTest.model.Actor;
import edu.daw.rico.ProyectTest.services.IActoresService;
import edu.daw.rico.ProyectTest.services.ICriticasService;
import edu.daw.rico.ProyectTest.services.IPeliculasService;

@SpringBootApplication
public class ProyectTestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProyectTestApplication.class, args);
	}

	@Autowired
	private IActoresService actoresService;

	@Autowired
	private IPeliculasService peliculasService;

	@Autowired ICriticasService criticasService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicación iniciada");
		
		System.out.println(criticasService.listarCriticas());
		
	}

}
