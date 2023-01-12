package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Usuario;
import service.ServicioBD;

@CrossOrigin(origins = "*")
@RestController
public class TeoricoPracticoController {

	@Autowired
	ServicioBD servicioBD;

	@GetMapping(value = "saludar", produces = MediaType.TEXT_PLAIN_VALUE)
	public String generarSaludo() {
		return "Prueba SuperComputación funciona el servicio";
	}

	@GetMapping(value = "allUsuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> getReservas() {
		return this.servicioBD.getAllUsuarios();
	}

	@PostMapping(value = "nuevoUsuario", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String nuevoUsuario(@RequestBody Usuario usuario) {
		if (this.servicioBD.generarUsuario(usuario))
			return "Usuario agregado";
		else
			return "Hubo algun error";
	}

	@PutMapping(value = "modificarUsuario", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String modificarUsuario(@RequestBody Usuario usuario) {
		if (this.servicioBD.modificarUsuario(usuario))
			return "Usuario modificado";
		else
			return "Hubo algun error";
	}

	@DeleteMapping(value = "eliminarUsuario/{id}")
	public String eliminarContacto(@PathVariable("id") int id) {
		if (this.servicioBD.eliminarUsuario(id))
			return "Usuario eliminado";
		else
			return "Hubo algun error";
	}
}
