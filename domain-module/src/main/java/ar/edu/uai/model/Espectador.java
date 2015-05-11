package ar.edu.uai.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Espectador extends Usuario {
	
	
	
	@OneToMany(mappedBy="comprador")
	private Collection<Venta> compras;
	
	private Collection<Tarjeta> tarjetas;
	//posible interfaz,consultar.

	@Override
	public boolean isEspectador() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEmpleado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdministrador() {
		// TODO Auto-generated method stub
		return false;
	}

}
