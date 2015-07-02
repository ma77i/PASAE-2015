package ar.edu.uai.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Teatro {

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	
	private String direccion;

	public Teatro(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;

	}

	@OneToMany (mappedBy="teatro")
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}