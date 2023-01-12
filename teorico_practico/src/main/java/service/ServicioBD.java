package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsuarioDao;
import model.Usuario;

@Service("ServicioBD")
public class ServicioBD {

	@Autowired
	UsuarioDao usuarioDao;

	public boolean generarUsuario(Usuario usuario) {
		return this.usuarioDao.generarUsuario(usuario);
	}

	public List<Usuario> getAllUsuarios() {
		return this.usuarioDao.getAllUsuarios();
	}
	
	@Transactional
	public boolean modificarUsuario(Usuario usuario) {
		return this.usuarioDao.modificarUsuario(usuario);
	}
	
	@Transactional
	public boolean eliminarUsuario(int id) {
		return this.usuarioDao.deleteUsuario(id);
	}
}
