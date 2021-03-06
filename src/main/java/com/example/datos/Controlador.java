package com.example.datos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:4200", maxAge = 3600) 
@RestController
@RequestMapping({"/personas"})
public class Controlador {
	@Autowired
	PersonaService service;
	//listar
	@GetMapping
	public List<Persona>listar(){
		return service.listar();
		
	}
	//agregar en add
	@PostMapping
	public Persona agregar(@RequestBody Persona p) {
		return service.add(p);
	}
	//listar id
	@GetMapping(path = {"/{id}"})
	public Persona listarId(@PathVariable("id") int id) {
		return service.listarId(id);
	}
	//actualizar campos
	@PutMapping(path = {"/{id}"})
	public Persona Editar(@RequestBody Persona p, @PathVariable("id") int id) {
		return service.edit(p);
	}
	//eliminar
	@DeleteMapping(path = {"/{id}"})
	public Persona delete(@PathVariable("id") int id) {
		return service.delete(id);
	}
	
	
}
