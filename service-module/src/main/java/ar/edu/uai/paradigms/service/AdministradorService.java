package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Empleado;
import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;

import ar.edu.uai.paradigms.dao.AdministradorDAO;


public class AdministradorService extends UsuarioService<Usuario> {
   
	private AdministradorDAO administradorDAO;

	
	public AdministradorDAO getAdministradorDAO() {
		return administradorDAO;
	}

	public void setAdministradorDAO(AdministradorDAO administradorDAO) {
		this.administradorDAO = administradorDAO;
	}   
	


    
  
	
   
    

	

	
	
}
