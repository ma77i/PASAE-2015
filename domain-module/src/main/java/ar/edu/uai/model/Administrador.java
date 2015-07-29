package ar.edu.uai.model;

import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario{

	public Administrador() {

		super();
	}

	public Administrador(String email, String password, String nombre,
						 String apellido, String estado) {
		super(email, password, nombre, apellido, estado);
		// TODO Auto-generated constructor stub
	}



}
