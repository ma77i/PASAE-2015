package ar.edu.uai.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Venta {
	
	public Venta() {

	}

	public Venta(Float monto, Integer coutas, String cvv, Collection<Asiento> asientos) {
		this.monto = monto;
		this.costoAdicional = (float) 0;
		//this.fechaVenta = fechaVenta;
		this.coutas = coutas;
		this.CVV = cvv;
		this.asientos = asientos;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Float monto;

	private Float costoAdicional;
	
	private Date fechaVenta;

	private String CVV;

    @ManyToOne (cascade=CascadeType.PERSIST)
	private Tarjeta tarjeta;

	private Integer coutas;
	
	@ManyToOne
	private Funcion funcion;
	
/*	@OneToMany
	@JoinTable(name = "VENT_ASI", joinColumns = @JoinColumn(name = "VENT_ID"), inverseJoinColumns = @JoinColumn(name = "ASI_ID"))
	private Collection<Asiento> asientos;
	//One to many unidireccional,la venta conoce los asientos unicamente.
*/	
    @ManyToOne
	private Espectador comprador;

	@OneToMany
	private Collection<Asiento> asientos;


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

	public Espectador getComprador() {
		return comprador;
	}

	public void setComprador(Espectador comprador) {
		this.comprador = comprador;
	}

   /* public Collection<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(Collection<Asiento> asientos) {
		this.asientos = asientos;
	}*/


	public String getCVV() {
		return CVV;
	}

	public void setCVV(String CVV) {
		this.CVV = CVV;
	}
}