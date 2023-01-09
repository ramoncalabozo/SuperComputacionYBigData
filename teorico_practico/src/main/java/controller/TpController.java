package controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="*")
@RestController

public class TpController {


	@GetMapping (value ="saludos", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saludo () {
		return "Esto es una prueba";
	}
}
