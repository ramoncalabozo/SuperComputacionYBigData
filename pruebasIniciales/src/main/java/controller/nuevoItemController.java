package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Item;
import service.ClienteAgendaService;

@RestController
public class nuevoItemController {
	@Autowired
	ClienteAgendaService service;
	
	@GetMapping(value="addContacto/{nombre}/{email}/{edad}")
	public void nuevoContacto(@PathVariable("nombre") String nombre,
			@PathVariable("email") String email,
			@PathVariable("edad") int edad) {
		this.service.procesarContacto(new Item(0, nombre, email, edad));
	}
}
