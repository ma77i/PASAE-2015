package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;


public abstract class UsuarioService<T> {
    
	private T usuarioDAO ;
	
	public T getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(T usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public UsuarioService(T usuarioDAO) {
		
		this.usuarioDAO = usuarioDAO;
	}
    
     public T saveUsuario(T usuario) {
		return  usuarioDAO.create(usuario);
	}
    
    public T retrieveUsuario(long identifier) {
		return this.usuarioDAO.retrieve(Usuario.class, identifier);
	}

	
    
}
