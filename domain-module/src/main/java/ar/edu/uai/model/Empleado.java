package ar.edu.uai.model;

import javax.persistence.Entity;

@Entity
public class Empleado extends Usuario {

	public Empleado(String email, String password, String nombre,
			String apellido,String usuario) {
		super(email, password, nombre, apellido,usuario);
		// TODO Auto-generated constructor stub
	}

	
	
}
