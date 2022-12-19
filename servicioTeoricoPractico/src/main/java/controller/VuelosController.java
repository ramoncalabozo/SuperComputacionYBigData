package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.VuelosDao;
import model.Vuelo;

@CrossOrigin(origins="*")
@RestController
public class VuelosController {
	
	@Autowired
	VuelosDao dao;

	@GetMapping (value ="vuelos/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> devolverVuelos (@PathVariable("plazas") int plazas) {
		List <Vuelo> vuelos = dao.devolverVuelos(plazas);
		return vuelos;
	}
	@Transactional
	@PutMapping (value= "vuelos/{idvuelo}/{plazas}")
	public void modificarVuelo (@PathVariable("idvuelo") int id,
			@PathVariable("plazas") int plazas) {
		Vuelo vuelo = dao.devolverVuelo(id);
		vuelo.setPlazas(vuelo.getPlazas()-plazas);
		dao.actualizarVuelo(vuelo);
	}
	
}

