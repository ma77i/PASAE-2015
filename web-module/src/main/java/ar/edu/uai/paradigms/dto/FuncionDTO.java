package ar.edu.uai.paradigms.dto;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FuncionDTO {

	private Date fecha;
	private Time hora;
	private long espectaculoId;

	@JsonCreator
	public FuncionDTO(@JsonProperty("fecha") Date fecha, @JsonProperty("hora") Time hora, @JsonProperty("espectaculoId") long espectaculoId) {
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

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public long getEspectaculoId() {
		return espectaculoId;
	}

	public void setEspectaculoId(long espectaculoId) {
		this.espectaculoId = espectaculoId;
	}

}
