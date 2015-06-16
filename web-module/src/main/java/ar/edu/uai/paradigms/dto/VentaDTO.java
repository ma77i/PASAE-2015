package ar.edu.uai.paradigms.dto;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Funcion;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Matias on 10/06/2015.
 */
public class VentaDTO {

	private float monto;
	private float costoAdicional;
	private Date fechaVenta;
	private int cuotas;
	private Long espectaculoId;
	private Long funcionId;
	private Long espectadorId;

	@JsonCreator
	public VentaDTO(@JsonProperty("monto") float monto, @JsonProperty("costoAdicional") float costoAdicional, @JsonProperty("fechaVenta") Date fechaVenta,
			@JsonProperty("cuotas") int cuotas, @JsonProperty("espectaculoId") long espectaculoId, @JsonProperty("funcionId") long funcionId,
			@JsonProperty("espectadorId") long espectadorId) {
		super();
		this.setMonto(monto);
		this.setCostoAdicional(costoAdicional);
		this.setFechaVenta(fechaVenta);
		this.setCuotas(cuotas);
		this.setFuncionId(funcionId);
		this.setEspectadorId(espectadorId);
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

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Long getFuncionId() {
		return funcionId;
	}

	public void setFuncionId(long funcionId) {
		this.funcionId = funcionId;
	}

	public Long getEspectadorId() {
		return espectadorId;
	}

	public void setEspectadorId(long espectadorId) {
		this.espectadorId = espectadorId;
	}

	public Long getEspectaculoId() {
		return espectaculoId;
	}

	public void setEspectaculoId(long espectaculoId) {
		this.espectaculoId = espectaculoId;
	}

	public String toString() {
		return "VentaDTO [monto=" + monto + ", costoAdicional=" + costoAdicional + ", fechaVenta=" + fechaVenta + ",cuotas=" + cuotas + ",comprador=" + espectadorId + "]"; // ACA
																																											// VA
																																											// LA
																																											// FUNCION
																																											// Y
																																											// ESPECTACULO
																																											// ?
	}

}
