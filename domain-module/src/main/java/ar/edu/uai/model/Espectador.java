package ar.edu.uai.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Espectador extends Usuario {
	
	
	public Espectador(){
		
	}
	
	
	public Espectador(String email, String password, String nombre,
			String apellido,String usuario) {
		super(email, password, nombre, apellido,usuario);
		// TODO Auto-generated constructor stub
	}



	@OneToMany(mappedBy="comprador")
	private Collection<Venta> compras;

	public Collection<Venta> getCompras() {
		return compras;
	}

	public void setCompras(Collection<Venta> compras) {
		this.compras = compras;
	}


	@OneToMany(mappedBy ="comprador")
	private Collection<Tarjeta> tarjetas;
	//posible interfaz,consultar.

	

}
