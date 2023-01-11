package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Usuario;
import service.ServicioBD;


@CrossOrigin(origins = "*")
@RestController
public class TeoricoPracticoController {
	
	@Autowired
	ServicioBD servicioBD;
	
	
	@GetMapping(value="saludar", produces=MediaType.TEXT_PLAIN_VALUE)
	public String generarSaludo() {
		return "Prueba SuperComputación funciona el servicio";
	}
	
	@GetMapping(value="allUsuarios", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> getReservas() {
		return this.servicioBD.getAllUsuarios();
	}
}
