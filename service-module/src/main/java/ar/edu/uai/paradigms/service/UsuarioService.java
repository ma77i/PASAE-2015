package ar.edu.uai.paradigms.service;


import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


@Validated
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
    
    public T retrieveUsuario(Long identifier) {
		T usuario;
		/*if (identifier != null)
			throw new MyException("El ID de usuario es requerido");
		else {
			usuario = this.usuarioDAO.retrieve((Class<T>) Usuario.class, identifier);
			if (usuario != null)
				throw new MyException("No se pudo encontrar usuario con ese ID");
			else
				return usuario;
		}*/
		return (this.usuarioDAO.retrieve((Class<T>) Usuario.class, identifier));
	}

    public T modificarDatosPersonales(T u){
		return this.usuarioDAO.update(u);
    	
    }
    public T modificarContrasena(T u){
		return usuarioDAO.update(u);
    	
    }
	public Usuario existeUsuario(String usuario){
		return usuarioDAO.existeUsuario(usuario);
	}
	
	public String getUserRole(String email,String password){
		return usuarioDAO.getUserRole(email,password);
	}
   


	

	
    
}
