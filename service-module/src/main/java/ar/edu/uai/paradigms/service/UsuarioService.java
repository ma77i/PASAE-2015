package ar.edu.uai.paradigms.service;


import org.springframework.transaction.annotation.Transactional;

import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;


public abstract class UsuarioService<T extends Usuario> {
    
	private UsuarioDAO<T> usuarioDAO;

	
	public UsuarioService(UsuarioDAO<T> usuarioDAO) {
		
		this.usuarioDAO = usuarioDAO;
	}
	

	/*@Required
	public void setUsuarioDAO(UsuarioDAO<T> usuarioDAO) { 
		super();
		this.usuarioDAO = usuarioDAO;
	}
*/
    @Transactional
     public Usuario saveUsuario(T usuario) {
		return   usuarioDAO.create(usuario);
	}
    
    public Usuario retrieveUsuario(long identifier) {
	   return this.usuarioDAO.retrieve(usuarioDAO.getPersistentClass(), identifier);
	}


	

	
    
}
