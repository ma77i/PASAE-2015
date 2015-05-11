package ar.edu.uai.paradigms.service;
import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Person;
import ar.edu.uai.model.Usuario;


public interface UsuarioService {

	public Usuario saveUsuario(Usuario usuario);

    public Usuario retrieveUsuario(Long identifier);


}
