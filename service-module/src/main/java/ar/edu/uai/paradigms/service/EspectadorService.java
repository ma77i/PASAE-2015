package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;


public class EspectadorService extends UsuarioService<Usuario> {

	public EspectadorService(UsuarioDAO usuarioDAO) {
		super(usuarioDAO);
		// TODO Auto-generated constructor stub
	}	
  
}
