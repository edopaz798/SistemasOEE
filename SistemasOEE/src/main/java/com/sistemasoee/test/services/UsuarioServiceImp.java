package com.sistemasoee.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sistemasoee.test.beans.Usuario;
import com.sistemasoee.test.dao.UsuarioDao;

public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
		
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public void altaUsuario(Usuario usuario) {
		usuarioDao.altaUsuario(usuario);
	}
	
	@Override
	public Usuario autenticarUsuario(Usuario usuario) {
		return usuarioDao.autenticacionUsuario(usuario);
	}

	@Override
	public List<Usuario> list() {		
		return usuarioDao.list();
	}

}
