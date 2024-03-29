package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository("usuarioDao")
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public List<Usuario> getAllUsuarios() {
		TypedQuery<Usuario> tQuery = this.em.createNamedQuery("Usuario.findAll", Usuario.class);
		return tQuery.getResultList();
	}

	@Transactional
	public boolean generarUsuario(Usuario usuario) {
		this.em.persist(usuario);
		return true;
	}

	@Transactional
	public boolean modificarUsuario(Usuario usuario) {
		this.em.merge(usuario);
		return true;
	}

	@Transactional
	public boolean deleteUsuario(int id) {
		Usuario usuario = this.em.find(Usuario.class, id);
		if (usuario != null) {
			this.em.remove(usuario);
			return true;
		} else {
			return false;
		}
	}
	
	public Usuario getUsuariosporEmail(String email) {
		TypedQuery<Usuario> tQuery = this.em.createNamedQuery("Usuario.findByEmail", Usuario.class);
		tQuery.setParameter(1, email);
		List<Usuario> usuario = tQuery.getResultList();
		return usuario.size()>0? usuario.get(0) : null;
	}

}
