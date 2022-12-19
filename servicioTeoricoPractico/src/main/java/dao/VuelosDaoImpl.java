package dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Vuelo;

@Repository
public class VuelosDaoImpl implements VuelosDao {
	@PersistenceContext
	EntityManager em;
	@Override
	public List<Vuelo> devolverVuelos(int plazas) {
		TypedQuery<Vuelo> tq = em.createNamedQuery("Vuelo.findAll", Vuelo.class);
		return tq.getResultList().stream().filter(t->t.getPlazas()>=plazas).collect(Collectors.toList());
	}
	@Override
	public Vuelo devolverVuelo(int idvuelo) {
		return em.find(Vuelo.class, idvuelo);
	}
	@Override
	public void actualizarVuelo (Vuelo vuelo) {
		em.merge(vuelo);
	}

}
