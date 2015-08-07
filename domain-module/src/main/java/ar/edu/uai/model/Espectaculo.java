package ar.edu.uai.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Espectaculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre", unique = true)
	private String nombre;
	
	private String descripcion;

	@OneToMany(mappedBy = "espectaculo", cascade = CascadeType.REMOVE)
	private Collection<Funcion> funciones;

	@OneToMany(mappedBy="espectaculo")
	private Collection<Sector> sectores;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Teatro teatro;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Categoria categoria;

	private String imagen;



	public Espectaculo() {

	}

	public Espectaculo(String nombre, String descripcion, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen=imagen;
	}




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

	public Collection<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(Collection<Sector> sectores) {
		this.sectores = sectores;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
