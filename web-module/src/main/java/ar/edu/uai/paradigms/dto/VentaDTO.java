package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by Matias on 10/06/2015.
 */
public class VentaDTO {
	private Long id;
	private Float monto;
	private Integer cuotas;
	private Long espectaculoId;
	private Long funcionId;
	private Long espectadorId;
	private Long tarjetaId;
	private String cvv;
	private Collection<AsientoDTO> asientos;

	@JsonCreator
	public VentaDTO(@JsonProperty("id") Long id, @JsonProperty("monto") Float monto,
					@JsonProperty("cuotas") Integer cuotas, @JsonProperty("espectaculoId") Long espectaculoId, @JsonProperty("funcionId") Long funcionId,
					@JsonProperty("espectadorId") Long espectadorId, @JsonProperty("tarjetaId") Long tarjetaId, @JsonProperty("cvv") String cvv, @JsonProperty("asientos") Collection<AsientoDTO> asientos) {
		super();
		this.setId(id);
		this.setMonto(monto);
		this.setCuotas(cuotas);
		this.setFuncionId(funcionId);
		this.setEspectadorId(espectadorId);
		this.setTarjetaId(tarjetaId);
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

	public Long getEspectaculoId() {
		return espectaculoId;
	}

	public void setEspectaculoId(Long espectaculoId) {
		this.espectaculoId = espectaculoId;
	}

	public Long getEspectadorId() {
		return espectadorId;
	}

	public void setEspectadorId(Long espectadorId) {
		this.espectadorId = espectadorId;
	}

	public Long getTarjetaId() {
		return tarjetaId;
	}

	public void setTarjetaId(Long tarjetaId) {
		this.tarjetaId = tarjetaId;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
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

	public String toString() {
		return "VentaDTO [monto=" + monto + ",cuotas=" + cuotas + ",comprador=" + espectadorId + ",espectaculoId=" + espectaculoId + ",tarjetaId=" + tarjetaId + "funcionId=" + funcionId + "]";

	}


}