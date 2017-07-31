package ar.edu.uai.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Collection;

@Entity
public class Espectaculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre", unique = true)
	private String nombre;

	@Column(name="descripcion",length = 1337)
	private String descripcion;

	@OneToMany(mappedBy = "espectaculo", cascade = CascadeType.REMOVE)
	private Collection<Funcion> funciones;

//	@OneToMany(mappedBy = "espectaculo", cascade = CascadeType.REMOVE)
//	private Collection<Sector> sectores;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Teatro teatro;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Categoria categoria;

	@Lob
	private Blob imagen;

	@Lob
	private Blob imagen_portada;



	public Espectaculo() {

	}

	public Espectaculo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;

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

	public Blob getImagen() {
		return imagen;
	}

	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}

	public Blob getImagen_portada() {
		return imagen_portada;
	}

	public void setImagen_portada(Blob imagen_portada) {
		this.imagen_portada = imagen_portada;
	}
}
