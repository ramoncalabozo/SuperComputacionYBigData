package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Item;

@Service
public class ClienteAgendaServiceImpl implements ClienteAgendaService {
	@Autowired
	RestTemplate template;
	String url = "http://localhost:8080";
	
	/*Recibe del controlador los datos del nuevo contacto y tiene que 
	 * interaccionar con el otro servicio para realizar las operaciones*/
	@Override
	public void procesarContacto(Item item) {
		Item contacto = template.getForObject(url + "/buscar/"+item.getEmail(), Item.class);
		if(contacto == null) 
			template.postForLocation(url+"/addContacto", item);
		else {
			contacto.setEdad(item.getEdad());
			contacto.setNombre(item.getNombre());
			template.put(url+"/modificar", contacto);
		}
	}

}
