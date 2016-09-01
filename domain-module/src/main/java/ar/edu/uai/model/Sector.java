package ar.edu.uai.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Sector {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombre;
	
	private Long monto;
	
	private Boolean agotado;

	@OneToMany(mappedBy="sector", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private Collection<Fila> filas;

	@ManyToOne
	private Espectaculo espectaculo;


	public Sector() {
		
	}

	public Sector(String nombre, Long monto) {
		this.nombre = nombre;
		this.monto = monto;
		this.agotado = false;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Espectaculo getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public boolean isAgotado() {
		return agotado;
	}

	public void setAgotado(boolean agotado) {
		this.agotado = agotado;
	}

	public Collection<Fila> getFilas() {
		return filas;
	}

	public void setFilas(Collection<Fila> filas) {
		this.filas = filas;
	}
}
