package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Email;


@Repository("emailDao")
public class EmailDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public boolean generarEmail(Email email) {
		this.em.persist(email);
		return true;
	}

	public List<Email> getAllEmail() {
		TypedQuery<Email> tQuery = this.em.createNamedQuery("Email.findAll", Email.class);
		return tQuery.getResultList();
	}

	@Transactional
	public boolean modificarEmail(Email email) {
		this.em.merge(email);
		return true;
	}

	@Transactional
	public boolean deleteEmail(int id) {
		Email email = this.em.find(Email.class, id);
		if (email != null) {
			this.em.remove(email);
			return true;
		} else {
			return false;
		}
	}
}
