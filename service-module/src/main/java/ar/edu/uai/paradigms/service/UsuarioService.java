package ar.edu.uai.paradigms.service;


import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;
import ar.edu.uai.paradigms.validators.UsuarioValidator;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.validation.Valid;

@Validated
public abstract class UsuarioService<T extends Usuario> {
    
	private UsuarioDAO<T> usuarioDAO;


    
	public UsuarioService(){
		
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UsuarioValidator());
	
	
	public UsuarioService(UsuarioDAO<T> usuarioDAO) {

		this.usuarioDAO = usuarioDAO;

	}
    
	public void setUsuarioDAO(UsuarioDAO<T> usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	@Transactional
	public T saveUsuario(@Valid T usuario) {
       /* BeanPropertyBindingResult result = new BeanPropertyBindingResult(usuario, "usuario");
        ValidationUtils.invokeValidator(usuarioValidator, usuario, result);
        if (result.hasErrors())
            throw new CustomInvalidArgEx("xxx");
        else*/
		return usuarioDAO.create(usuario);
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