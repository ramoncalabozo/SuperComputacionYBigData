package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Hotel;

@Repository
public class HotelesDaoImpl implements HotelesDao {

	@PersistenceContext
	EntityManager em;
	@Override
	public List<Hotel> devolverHoteles() {
		TypedQuery<Hotel> tq = em.createNamedQuery("Hotel.findAll", Hotel.class);
		return tq.getResultList();
	}

}
