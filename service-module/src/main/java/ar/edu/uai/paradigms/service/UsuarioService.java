package ar.edu.uai.paradigms.service;

import org.springframework.beans.factory.annotation.Required;

import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;


public abstract class UsuarioService<T extends Usuario> {
    
	private UsuarioDAO<T> usuarioDAO;

	private Class<T> persistentClass;

	@Required
	public void setUsuarioDAO(UsuarioDAO<T> usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

    
     public Usuario saveUsuario(T usuario) {
		return   usuarioDAO.create(usuario);
	}
    
    public Usuario retrieveUsuario(long identifier) {
		return this.usuarioDAO.retrieve(Usuario.class, identifier);
	}

	
    
}
