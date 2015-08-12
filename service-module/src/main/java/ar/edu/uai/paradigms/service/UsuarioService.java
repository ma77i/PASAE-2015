package ar.edu.uai.paradigms.service;


import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;
import org.springframework.transaction.annotation.Transactional;


public abstract class UsuarioService<T extends Usuario> {

	private UsuarioDAO<T> usuarioDAO;


	public UsuarioService() {

	}


	public UsuarioService(UsuarioDAO<T> usuarioDAO) {

		this.usuarioDAO = usuarioDAO;

	}

	public void setUsuarioDAO(UsuarioDAO<T> usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	@Transactional
	public T saveUsuario(T usuario) {
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
	
	public T retrieveUsuarioPorNombre(String username){
		return (T) (this.usuarioDAO.retrieveByUserName( username));
	}

	@Transactional
	public T modificarDatosPersonales(T u, String nombre, String apellido, String password) {
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setPassword(password);
		return this.usuarioDAO.update(u);

	}


	@Transactional
	public T modificarEstado(T usuario, String estado) {
		usuario.setEstado(estado);
		return this.usuarioDAO.update(usuario);
	}

	public String getUserRole(String email, String password) {
		return usuarioDAO.getUserRole(email, password);
	}


}