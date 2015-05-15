package ar.edu.uai.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Teatro {

	
	
	private String nombre;
	
	private String direccion;
	
	
	@OneToMany (mappedBy="espectaculo")
    private Collection<Espectaculo> espectaculos;

	public Teatro() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

	public Collection<Espectaculo> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(Collection<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
	
	
	
}