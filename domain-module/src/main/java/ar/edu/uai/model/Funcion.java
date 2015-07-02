package ar.edu.uai.model;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Funcion {

	
	public Funcion(Date fecha, Date hora, Espectaculo espectaculo){
		this.fecha = fecha;
		this.hora = hora;
		this.espectaculo = espectaculo;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public Funcion() {
		
	}

	private Date fecha;
	
	private Date hora;
	
	@ManyToOne
	private Espectaculo espectaculo;
	
	// @OneToMany
	//  @JoinTable(name = "FUN_SEC", joinColumns = @JoinColumn(name = "FUN_ID"), inverseJoinColumns = @JoinColumn(name = "SEC_ID"))
	//private Collection<Sector> sectores;
	 // una funcion tiene determinados sectores.
	
	//en el uml borrar la relacion con asientos
	
	
	@OneToMany(mappedBy="funcion")
	private Collection<Venta> ventas;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Espectaculo getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}

	/*public Collection<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(Collection<Sector> sectores) {
		this.sectores = sectores;
	}*/

	public Collection<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Collection<Venta> ventas) {
		this.ventas = ventas;
	}

	/**
	 * Retorna el n&ucute;mero de asientos libres para cada sector.
	 * 
	 * @return
	 */
	private int getAsientosLibres(){
		return 0;
	}
}
