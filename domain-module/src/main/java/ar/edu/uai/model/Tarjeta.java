package ar.edu.uai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Tarjeta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nro_tarjeta;

	private Integer cvv;

	private Date fecha_vencimiento;

	/*@OneToMany(mappedBy="tarjeta")
	private Collection<Venta> ventas;*/

//	@ManyToOne
//	private Espectador comprador;


	public Tarjeta() {
		
	}

	public Tarjeta (String nro_tarjeta, int cvv, Date fecha_vencimiento){
		this.nro_tarjeta=nro_tarjeta;
		this.cvv=cvv;
		this.fecha_vencimiento=fecha_vencimiento;
		//this.ventas = new ArrayList<Venta>();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNro_tarjeta() {
		return nro_tarjeta;
	}

	public void setNro_tarjeta(String nro_tarjeta) {
		this.nro_tarjeta = nro_tarjeta;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	/*public Collection<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Collection<Venta> ventas) {
		this.ventas = ventas;
	}*/
}
