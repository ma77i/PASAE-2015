package ar.edu.uai.paradigms.service;

import ar.edu.uai.paradigms.dao.UsuarioDAO;

public class LoginServiceImpl implements LoginService {

	public LoginServiceImpl(UsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	
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

	@Override
	public Boolean isUserActive(String email, String password) {
		return usuarioDAO.isUserActive (email,password);
	}


}
