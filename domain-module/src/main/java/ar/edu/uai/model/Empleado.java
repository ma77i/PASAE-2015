package ar.edu.uai.model;

import javax.persistence.Entity;

@Entity
public class Empleado extends Usuario {

	@Override
	public boolean isAdministrador() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpleado() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEspectador() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
