package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Empleado;
import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;

import ar.edu.uai.paradigms.dao.AdministradorDAO;


public class AdministradorService extends UsuarioService<Usuario> {
   
	private AdministradorDAO administradorDAO;

	private EspectadorService espectadorService;
	
	private EmpleadoService empleadoService;
	
	public AdministradorDAO getAdministradorDAO() {
		return administradorDAO;
	}

	public void setAdministradorDAO(AdministradorDAO administradorDAO) {
		this.administradorDAO = administradorDAO;
	}   
	
	public EspectadorService getEspectadorService() {
		return espectadorService;
	}

	public void setEspectadorService(EspectadorService espectadorService) {
		this.espectadorService = espectadorService;
	}

	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}

	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}
    
    public Collection<Espectador> listarEspectadores(){
		return espectadorService.listarEspectadores();
		
    }
    
    public Collection<Empleado> listarEmpleados(){
     	return empleadoService.listarEmpleados();
       
    }
    
	
   
    

	

	
	
}
