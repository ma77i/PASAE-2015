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
    
  /*  public Collection<Usuario> listarUsuarios(){
		return  usuarioDAO.list();
    	
    }
   */ 
    public T modificarDatosPersonales(T u){
		return this.usuarioDAO.update(u);
    	
    }
    public T modificarContrasena(T u){
		return usuarioDAO.update(u);
    	
    }
   
    


	

	
    
}
