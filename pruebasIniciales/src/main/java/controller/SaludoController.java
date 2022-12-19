package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SaludoController {
	
	@GetMapping(value="saludar", produces=MediaType.TEXT_PLAIN_VALUE)
	public String generarSaludo() {
		return "Bienvenido a mi servicio";
	}
}