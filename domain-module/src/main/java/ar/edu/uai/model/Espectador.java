package ar.edu.uai.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Espectador extends Usuario {
	

	
	public Espectador(String email, String password, String nombre,
			String apellido) {
		super(email, password, nombre, apellido);
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
