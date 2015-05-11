package ar.edu.uai.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Teatro {

	
	
	private String nombre;
	
	private String direccion;
	
	
	
	@OneToMany (mappedBy="sector")
	private Collection<Sector> sectores;
	
	
	@OneToMany (mappedBy="espectaculo")
    private Collection<Espectaculo> espectaculos;

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

	public Collection<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(Collection<Sector> sectores) {
		this.sectores = sectores;
	}

	public Collection<Espectaculo> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(Collection<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
	
	
	
}