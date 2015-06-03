package ar.edu.uai.paradigms.service;


import java.util.Collection;

import ar.edu.uai.model.Empleado;
import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.EmpleadoDAO;
import ar.edu.uai.paradigms.dao.EspectadorDAO;
import ar.edu.uai.paradigms.dao.UsuarioDAO;

public class EmpleadoService extends  UsuarioService<Usuario>{


	private EmpleadoDAO empleadoDAO; 

	private EspectaculoService espectaculoService;
	
	public EspectaculoService getEspectaculoService() {
		return espectaculoService;
	}

	public void setEspectaculoService(EspectaculoService espectaculoService) {
		this.espectaculoService = espectaculoService;
	}

	public EmpleadoDAO getEmpleadoDAO() {
		return empleadoDAO;
	}

	public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}
    
	public Collection<Empleado>listarEmpleados(){
    	return empleadoDAO.list();
    }	
	
	public Collection<Funcion>listarFunciones(){
		return null;
 	 //esto iria con lo de lucas	
	}
	
	public Collection<Espectaculo> listarEspectaculos(){
		return espectaculoService.listarEspectaculos();
	}
	
	public Espectaculo saveEspectaculo(Espectaculo espectaculo){
		 return this.espectaculoService.saveEspectaculo(espectaculo);
	}
    
	public void deleteEspectaculo(long identifier){
		 this.espectaculoService.deleteEspectaculo(identifier);
	}
	
	public Espectaculo retrieveEspectaculo(long identifier){
		return espectaculoService.retrieveEspectaculo(identifier);
	}

    public Espectaculo modificarEspectaculo(Espectaculo espectaculo){
    	return espectaculoService.modificarEspectaculo(espectaculo);
    }
	
}
