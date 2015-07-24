package ar.edu.uai.paradigms.service;


import ar.edu.uai.model.Empleado;
import ar.edu.uai.paradigms.dao.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collection;

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

	public Collection<Empleado> listarEmpleadosPorCampoIngresado(String input) {
		return empleadoDAO.listarEmpleadosPorCampoIngresado(input);

	}

	
}
