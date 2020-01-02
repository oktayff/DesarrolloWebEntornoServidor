package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	public PersonaService ps;
	
	@GetMapping("/personas")
	public List<Persona> getAll() {
		
		return ps.getAll();
	}
	
	@PostMapping("/personas/crear")
	public void createPersona(@RequestBody Persona p) {
		
		ps.createPersona(p);
	}
	
	@PutMapping("/personas/{dni}")
	public void actualizarPersona(@RequestBody Persona p, @PathVariable String dni) {
		
		ps.updatePersona(p, dni);
	}
	
	@DeleteMapping("/personas/{dni}")
	public void borrarPersona(@PathVariable String dni) {
		
		ps.deletePersona(dni);
	}

}
