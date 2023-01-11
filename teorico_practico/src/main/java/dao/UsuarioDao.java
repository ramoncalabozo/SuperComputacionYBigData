package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository("usuarioDao")
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Usuario> getAllUsuarios(){
		TypedQuery<Usuario> tQuery = this.em.createNamedQuery("Usuario.findAll", Usuario.class);
		return tQuery.getResultList();
	}
}
