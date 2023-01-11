package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsuarioDao;
import model.Usuario;

@Service("ServicioBD")
public class ServicioBD {

	@Autowired
	UsuarioDao usuarioDao;
	
	
	public List<Usuario> getAllUsuarios() {
		return this.usuarioDao.getAllUsuarios();
	}
}
