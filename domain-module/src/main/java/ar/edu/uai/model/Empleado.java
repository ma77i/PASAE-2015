package ar.edu.uai.model;

import javax.persistence.Entity;

@Entity
public class Empleado extends Usuario {

	public Empleado() {
		super();
	}

	public Empleado(String email, String password, String nombre,
			String apellido) {
		super(email, password, nombre, apellido);
		// TODO Auto-generated constructor stub
	}

	
	
}
