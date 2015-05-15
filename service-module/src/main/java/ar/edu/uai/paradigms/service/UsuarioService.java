package ar.edu.uai.paradigms.service;
import ar.edu.uai.model.Usuario;

public interface UsuarioService {

	public Usuario saveUsuario(Usuario usuario);

   public Usuario retrieveUsuario(long identifier);


}
