package edu.daw.rico.ProyectTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.daw.rico.ProyectTest.services.IActoresService;

@SpringBootApplication
public class ProyectTestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProyectTestApplication.class, args);
	}

	@Autowired
	private IActoresService actoresService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicación iniciada");
		System.out.println(actoresService.listarActores());
		System.out.println("Eliminando actor con id 2: " + actoresService.eliminarActorPorId(2L));
		
	}

}
