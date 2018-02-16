package com.sistemasoee.test.dao;

import com.sistemasoee.test.beans.Usuario;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioDaoDB implements UsuarioDao {

	@Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionfactory(SessionFactory sessionfactory) {
        this.sessionFactory = sessionfactory;
    }
	
	@Override
	public void altaUsuario(Usuario usuario) {
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        if(usuario!=null){
            try {
                session.save(usuario);
                tx.commit();
                session.close();
            } catch (Exception e) {
                tx.rollback();
                session.close();
                e.printStackTrace();                
            }
        }

	}

	@Override
	@Transactional
	public Usuario autenticacionUsuario(Usuario usuario) {
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "from Usuario as a where a.email =:email and a.contrasena =:contrasena";
        try {
            Query query = session.createQuery(hql);
            query.setString("email", usuario.getEmail());
            query.setString("contrasena", usuario.getContrasena());
            usuario = (Usuario) query.uniqueResult();
            tx.commit();
            session.close();
        } catch (Exception e) {
            tx.rollback();
            session.close();
            e.printStackTrace();
        }
        return usuario;
    }

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Usuario> list() {
		Session session = sessionFactory.openSession();
		List<Usuario> usuarios = null;
		try {
			usuarios = (List<Usuario>)session.createQuery("from Usuario").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
