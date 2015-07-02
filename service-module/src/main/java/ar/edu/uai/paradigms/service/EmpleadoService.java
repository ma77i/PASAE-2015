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
import org.springframework.beans.factory.annotation.Required;

public class EmpleadoService extends  UsuarioService<Empleado>{


	private EmpleadoDAO empleadoDAO;

	public EmpleadoDAO getEmpleadoDAO() {
		return empleadoDAO;
	}

	@Required
	public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	} 

	public Collection<Empleado>listarEmpleados(){
		return empleadoDAO.list();
	}
	
	

	
}
