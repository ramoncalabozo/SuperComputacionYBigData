package dao;

import java.util.List;

import model.Vuelo;

public interface VuelosDao {
	
	public List <Vuelo> devolverVuelos(int plazas);
	
	public Vuelo devolverVuelo( int idvuelo);
	
	public void actualizarVuelo(Vuelo vuelo);

}
