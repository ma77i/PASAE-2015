package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by Matias on 10/06/2015.
 */
public class VentaDTO {
	private Long id;
	private Long monto;
	private Integer cuotas;
	private Long funcionId;
	private Long espectadorId;
	private String numeroTarjeta;
	private String cvv;
	private Collection<AsientoDTO> asientos;

	@JsonCreator
	public VentaDTO(
			@JsonProperty("id") Long id,
			@JsonProperty("monto") Long monto,
					@JsonProperty("cuotas") Integer cuotas, 
					@JsonProperty("funcionId") Long funcionId,
					@JsonProperty("numeroTarjeta") String numeroTarjeta,
					@JsonProperty("cvv") String cvv,
					@JsonProperty("asientos") Collection<AsientoDTO> asientos) {
		super();
		this.setId(id);
		this.setMonto(monto);
		this.setCuotas(cuotas);
		this.setFuncionId(funcionId);
//		this.setEspectadorId(espectadorId);
		this.setNumeroTarjeta(numeroTarjeta);
		this.setCvv(cvv);
		this.setAsientos(asientos);
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCuotas() {
		return cuotas;
	}

	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}

	public Long getEspectadorId() {
		return espectadorId;
	}

	public void setEspectadorId(Long espectadorId) {
		this.espectadorId = espectadorId;
	}


	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public Long getFuncionId() {
		return funcionId;
	}

	public void setFuncionId(Long funcionId) {
		this.funcionId = funcionId;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Collection<AsientoDTO> getAsientos() {
		return asientos;
	}

	public void setAsientos(Collection<AsientoDTO> asientos) {
		this.asientos = asientos;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String toString() {
		return "VentaDTO [monto=" + monto + ",cuotas=" + cuotas + ",comprador=" + espectadorId + ",funcionId=" + funcionId + "]";

	}


}