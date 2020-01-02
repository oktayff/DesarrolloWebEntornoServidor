package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Persona;

public interface PersonaService {
	
	public List<Persona> getAll();
	
	public void createPersona(Persona p);
	
	public void updatePersona(Persona p, String dni);
	
	public void deletePersona(String dni);
	

}
