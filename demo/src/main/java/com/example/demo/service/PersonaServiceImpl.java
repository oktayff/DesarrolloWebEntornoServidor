package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;


@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	public PersonaRepository pr;

	@Override
	public List<Persona> getAll() {
		
		List<Persona> personas = pr.findAll();
		
		return personas;
	}

	@Override
	public void createPersona(Persona p) {
		
		//Crear un objeto nuevo
		Persona pers = new Persona(p.getDni(), p.getNombre(), p.getEdad());
		
		//Comprobar si la persona existe, si existe lanzamos error ya que no se 
		//puede insertar
		if(pr.findById(pers.getDni()).isPresent()) {
			throw new RuntimeException();
		}else {
			pr.save(pers);
		}	
	}

	@Override
	public void updatePersona(Persona p, String dni) {
		
		/*
		 * Comprobamos si existe la persona, si existe la vamos a cojer con .get()
		 *  y despues vamos a modificar sus campos 
		 *  y la vamos a introducir como si fuese una nueva
		 */
		if(pr.findById(dni).isPresent()) {
			Persona pers = pr.findById(dni).get();
			pers.setNombre(p.getNombre());
			pers.setEdad(p.getEdad());
			pr.save(pers);
		}else {
			throw new RuntimeException();
		}
	}

	@Override
	public void deletePersona(String dni) {
		
		/*
		 * Comprobamos si existe la persona con el dni introducido, si existe la obtenemos
		 * con .get() y la eliminamos.
		 */
		Optional<Persona> perss = pr.findById(dni);
		
		if(perss.isPresent()) {
			Persona personaBorrarPersona = perss.get();
			
			pr.delete(personaBorrarPersona);
			
		}else {
			throw new RuntimeException();
		}		
	}
}
