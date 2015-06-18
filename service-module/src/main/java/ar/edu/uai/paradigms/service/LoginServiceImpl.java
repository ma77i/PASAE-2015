package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;

public class LoginServiceImpl implements LoginService {
	
//	public LoginServiceImpl (){
//		super();	
//	}
	
	UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public String authenticate(String email, String password) {
		return usuarioDAO.getUserRole(email, password);
	}

	
}