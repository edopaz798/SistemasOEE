package com.sistemasoee.test.services;

import java.util.List;

import com.sistemasoee.test.beans.Usuario;

public interface UsuarioService {
	
	public void altaUsuario(Usuario usuario);
	public Usuario autenticarUsuario(Usuario usuario);
	public List<Usuario> list();

}
