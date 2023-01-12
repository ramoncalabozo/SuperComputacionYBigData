package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmailDao;
import dao.UsuarioDao;
import model.Email;
import model.Usuario;

@Service("ServicioBD")
public class ServicioBD {

	@Autowired
	UsuarioDao usuarioDao;
	@Autowired
	EmailDao emailDao;

	/*
	 * ****************************************************************** USUARIOS
	 */

	public List<Usuario> getAllUsuarios() {
		return this.usuarioDao.getAllUsuarios();
	}
	
	public boolean generarUsuario(Usuario usuario) {
		return this.usuarioDao.generarUsuario(usuario);
	}

	@Transactional
	public boolean modificarUsuario(Usuario usuario) {
		return this.usuarioDao.modificarUsuario(usuario);
	}

	@Transactional
	public boolean eliminarUsuario(int id) {
		return this.usuarioDao.deleteUsuario(id);
	}
	
	public Usuario getUsuariosporEmail(String nombre) {
		return this.usuarioDao.getUsuariosporEmail(nombre);
	}

	/*
	 * ****************************************************************** EMAILS
	 */

	public List<Email> getAllEmails() {
		return this.emailDao.getAllEmail();
	}

	public boolean generarEmail(Email email) {
		return this.emailDao.generarEmail(email);
	}
	
	
	@Transactional
	public boolean modificarEmail(Email email) {
		return this.emailDao.modificarEmail(email);
	}

	@Transactional
	public boolean eliminarEmail(int id) {
		return this.emailDao.deleteEmail(id);
	}
}
