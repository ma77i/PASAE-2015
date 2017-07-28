package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class FuncionDTO {


	private Long id;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Brazil/East")
	private Date fecha;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Brazil/East")
	private Date hora;

	private long espectaculoId;


	@JsonCreator
	public FuncionDTO(@JsonProperty("id") Long id, @JsonProperty("fecha") Date fecha, @JsonProperty("hora") Date hora, @JsonProperty("espectaculoId") long espectaculoId) {
		super();
		this.setId(id);
		this.setFecha(fecha);
		this.setHora(hora);
		this.setEspectaculoId(espectaculoId);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public long getEspectaculoId() {
		return espectaculoId;
	}

	public void setEspectaculoId(long espectaculoId) {
		this.espectaculoId = espectaculoId;
	}

	/*public String toString() {
		//return "FuncionDTO [fecha=" + fecha + ", hora=" + hora + ",espectaculoId=" + espectaculoId + "]";

	}
*/
}
