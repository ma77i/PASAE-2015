package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Administrador;
import ar.edu.uai.model.Empleado;
import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;

import ar.edu.uai.paradigms.dao.AdministradorDAO;
import org.springframework.beans.factory.annotation.Required;


public class AdministradorService extends UsuarioService<Administrador> {
   
	private AdministradorDAO administradorDAO;

	
	public AdministradorDAO getAdministradorDAO() {
		return administradorDAO;
	}

	@Required
	public void setAdministradorDAO(AdministradorDAO administradorDAO) {
		this.administradorDAO = administradorDAO;
	}   
	


    
  
	
   
    

	

	
	
}
