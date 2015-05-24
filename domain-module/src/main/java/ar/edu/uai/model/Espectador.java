package ar.edu.uai.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Espectador extends Usuario {
	
	
	
	public Espectador(String email, String password, String nombre,
			String apellido) {
		super(email, password, nombre, apellido);
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy="comprador")
	private Collection<Venta> compras;
	
//	private Collection<Tarjeta> tarjetas;
	//posible interfaz,consultar.

	

}
