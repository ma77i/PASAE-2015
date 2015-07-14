package ar.edu.uai.model;

import javax.persistence.*;
import java.util.Collection;

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

	@Column(name = "nombre", unique = true)
	private String nombre;
	
	private String descripcion;
	
	 @OneToMany(mappedBy="espectaculo")
	private Collection<Funcion> funciones;
	 
	@OneToMany(mappedBy="espectaculo")
	private Collection<Sector> sectores;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Teatro teatro;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Categoria categoria;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Teatro getTeatro() {
		return teatro;
	}

	public void setTeatro(Teatro teatro) {
		this.teatro = teatro;
	}
}
