package ar.edu.uai.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Espectaculo {

	public Espectaculo() {
		
	}

	public Espectaculo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	 @OneToMany(mappedBy="espectaculo")
	private Collection<Funcion> funciones;
	 
	@OneToMany(mappedBy="espectaculo")
	private Collection<Sector> sectores;
	 
	@ManyToOne
	private Teatro teatro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(Collection<Funcion> funciones) {
		this.funciones = funciones;
	}

	private Collection<Funcion> getFuncionesPorCriterio(){
		return null;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
