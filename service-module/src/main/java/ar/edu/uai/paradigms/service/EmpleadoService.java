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
		
	}
	
	public Collection<Espectaculo> listarEspectaculos(){
		return espectaculoService.
	}
	


}
