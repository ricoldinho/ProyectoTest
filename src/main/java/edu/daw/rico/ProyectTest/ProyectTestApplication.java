package edu.daw.rico.ProyectTest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.daw.rico.ProyectTest.model.Actor;
import edu.daw.rico.ProyectTest.services.IActoresService;
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
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicación iniciada");
		Actor actorAInsertar = new Actor("Pablo", "Salgado", LocalDate.of(2006, 11, 27), true);
		Actor actorAModificar = new Actor(33L, "Leonardo", "Di Caprio", LocalDate.of(1974, 11, 11), false);
		System.out.println("OPERACION CREATE");
		System.out.println(actoresService.insertarActor(actorAInsertar));
		System.out.println("OPERACION READ todos");
		actoresService.listarActores().forEach(System.out::println);
		System.out.println("OPERACION READ por ID");
		System.out.println(actoresService.listarActorPorId(5L));
		System.out.println("OPERACION UPDATE");
		System.out.println(actoresService.modificarPorId(actorAModificar));
		System.out.println("OPERACION DELETE");
		actoresService.eliminarActorPorId(26L);
		System.out.println("ACTORES DESPUES DE OPERACIONES");
		actoresService.listarActores().forEach(System.out::println);
		
	}

}
