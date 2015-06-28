package ar.edu.uai.paradigms.service;



import org.springframework.transaction.annotation.Transactional;

import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;


public abstract class UsuarioService<T extends Usuario> {
    
	private UsuarioDAO<T> usuarioDAO;


    
	public UsuarioService(){
		
	}
	
	
	public UsuarioService(UsuarioDAO<T> usuarioDAO) {

		this.usuarioDAO = usuarioDAO;

	}
    
	public void setUsuarioDAO(UsuarioDAO<T> usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	@Transactional
     public T saveUsuario(T usuario) {
		return   usuarioDAO.create(usuario);
	}
    
    public T retrieveUsuario(long identifier) {
	   return this.usuarioDAO.retrieve((Class<T>) Usuario.class,identifier);
	}

	@Transactional
    public T modificarDatosPersonales(T u){
		T usuario=this.retrieveUsuario(u.getId());
		usuario.setEmail(u.getEmail());
		usuario.setPassword(u.getPassword());
		usuario.setNombre(u.getNombre());
		usuario.setUsuario(u.getUsuario());
		return this.usuarioDAO.update(usuario);
    	
    }
	@Transactional
    public T modificarContrasena(T u){
		T usuario=this.retrieveUsuario(u.getId());
		usuario.setPassword(u.getPassword());
		return usuarioDAO.update(usuario);
    	
    }
	public Usuario existeUsuario(String email){
		return usuarioDAO.existeUsuario(email);
	}
	
	public String getUserRole(String email,String password){
		return usuarioDAO.getUserRole(email,password);
	}
   
    


	

	
    
}
