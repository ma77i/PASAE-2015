package ar.edu.uai.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private float monto;
	
	private float costoAdicional;
	
	private Date fechaVenta;
	
	private Tarjeta tarjeta;
	// posible interfaz, consultar.
	
	private int coutas;
	
	@ManyToOne
	private Funcion funcion;
	
/*	@OneToMany
	@JoinTable(name = "VENT_ASI", joinColumns = @JoinColumn(name = "VENT_ID"), inverseJoinColumns = @JoinColumn(name = "ASI_ID"))
	private Collection<Asiento> asientos;
	//One to many unidireccional,la venta conoce los asientos unicamente.
*/	
    @ManyToOne
	private Espectador comprador;
	
	/**
	 * Aplica descuento a la venta
	 */
	private void aplicarDescuento(){
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

	public float getCostoAdicional() {
		return costoAdicional;
	}

	public void setCostoAdicional(float costoAdicional) {
		this.costoAdicional = costoAdicional;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public int getCoutas() {
		return coutas;
	}

	public void setCoutas(int coutas) {
		this.coutas = coutas;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

/*	public Collection<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(Collection<Asiento> asientos) {
		this.asientos = asientos;
	}*/

}
