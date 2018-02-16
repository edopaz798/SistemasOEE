package com.sistemasoee.test.dao;

import java.util.List;

import com.sistemasoee.test.beans.Usuario;

public interface UsuarioDao {
	
	public void altaUsuario(Usuario usuario);
    public Usuario autenticacionUsuario(Usuario usuario);
    public List<Usuario> list();

}
