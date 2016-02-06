package ar.edu.uai.model;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Teatro {

	@Id @GeneratedValue
	private long id;


	@Column(name = "nombre", unique = true)
	private String nombre;
	
	private String direccion;

	private String cuit;

	private String propietario;

	public Teatro(String nombre, String direccion, String cuit, String propietario) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cuit=cuit;
		this.propietario=propietario;
	}

	@OneToMany(mappedBy = "teatro", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
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


	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
}