package ar.edu.uai.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Sector {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombre;
	
	private Float monto;
	
	private Boolean agotado;
	
	private Integer asientosLibres;
	
	@OneToMany(mappedBy="sector")
	private Collection<Asiento> asientos;

	@ManyToOne
	private Espectaculo espectaculo;
	

	
	
	public Sector() {
		
	}

	public Sector(String nombre, Float monto, Espectaculo espectaculo, int asientosLibres) {
		this.monto = monto;
		this.nombre = nombre;
		this.espectaculo = espectaculo;
		this.asientosLibres = asientosLibres;
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

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public boolean isAgotado() {
		return agotado;
	}

	public void setAgotado(boolean agotado) {
		this.agotado = agotado;
	}

	public int getAsientosLibres() {
		return asientosLibres;
	}

	public void setAsientosLibres(int asientosLibres) {
		this.asientosLibres = asientosLibres;
	}

	public Collection<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(Collection<Asiento> asientos) {
		this.asientos = asientos;
	}
}
