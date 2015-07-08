package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Administrador;
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
