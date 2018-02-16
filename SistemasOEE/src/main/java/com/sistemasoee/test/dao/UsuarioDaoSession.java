package com.sistemasoee.test.dao;

import com.sistemasoee.test.beans.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoSession implements UsuarioDao {

	@SuppressWarnings("unused")
	@Autowired
    private SessionFactory sessionFactory;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
     

	
	@Override
	public void altaUsuario(Usuario usuario) {		
        if(usuario!=null){
            try {
            	usuarios.add(usuario);
            } catch (Exception e) {
                e.printStackTrace();                
            }
        }

	}

	@Override
	public Usuario autenticacionUsuario(Usuario usuario) {		
        try {
        	for (Usuario usr : usuarios) {
				if (usr.getEmail().equals(usuario.getEmail()) && usr.getContrasena().equals(usuario.getContrasena())) {
					return usr;
				}
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


	@Override
	public List<Usuario> list() {
		return usuarios;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
