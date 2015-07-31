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

	private Integer asientos_libres;

	@OneToMany(mappedBy="sector")
	private Collection<Fila> filas;

	@ManyToOne
	private Espectaculo espectaculo;

	//private Collection<Sector> sectores_contiguos;

	

	
	
	public Sector() {
		
	}

	public Sector(String nombre, Float monto, Espectaculo espectaculo, Integer asientos_libres, Integer nro_asientos) {
		this.monto = monto;
		this.nombre = nombre;
		this.espectaculo = espectaculo;
		this.asientos_libres = asientos_libres;

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

	public int getAsientos_libres() {
		return asientos_libres;
	}

	public void setAsientos_libres(int asientos_libres) {
		this.asientos_libres = asientos_libres;
	}

	public void setAsientos_libres(Integer asientos_libres) {
		this.asientos_libres = asientos_libres;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Collection<Fila> getFilas() {
		return filas;
	}

	public void setFilas(Collection<Fila> filas) {
		this.filas = filas;
	}
}
