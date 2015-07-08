package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FuncionDTO {

	private Date fecha;
	private Date hora;
	private long espectaculoId;

	@JsonCreator
	public FuncionDTO(@JsonProperty("fecha") Date fecha, @JsonProperty("hora") Date hora, @JsonProperty("espectaculoId") long espectaculoId) {
		super();
		this.setFecha(fecha);
		this.setHora(hora);
		this.setEspectaculoId(espectaculoId);

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

	public long getEspectaculoId() {
		return espectaculoId;
	}

	public void setEspectaculoId(long espectaculoId) {
		this.espectaculoId = espectaculoId;
	}

	public String toString() {
		return "FuncionDTO [fecha=" + fecha + ", hora=" + hora + ",espectaculoId=" + espectaculoId + "]";

	}

}
