package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class SectorDTO {

	private Long id;
	private String nombre;
	private Float monto;
	private Boolean agotado;
	//private Integer asientosLibres;
	//private Integer nro_asientos;
	//private Integer nro_filas;
	private Long espectaculoId;
	;

	@JsonCreator
	public SectorDTO(@JsonProperty("id") Long id, @JsonProperty("nombre") String nombre, @JsonProperty("monto") Float monto, @JsonProperty("agotado") Boolean agotado, @JsonProperty("espectaculoId") Long espectaculoId) {

		this.setId(id);
		this.setNombre(nombre);
		this.setMonto(monto);
		this.setAgotado(agotado);
		this.setEspectaculoId(espectaculoId);

		/*this.asientosLibres = asientosLibres;
		this.nro_asientos = nro_asientos;
		this.nro_filas = nro_filas;*/
	}



	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Boolean getAgotado() {
		return agotado;
	}

	public void setAgotado(Boolean agotado) {
		this.agotado = agotado;
	}

	public Long getEspectaculoId() {
		return espectaculoId;
	}

	public void setEspectaculoId(Long espectaculoId) {
		this.espectaculoId = espectaculoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public Integer getAsientosLibres() {
		return asientosLibres;
	}

	public void setAsientosLibres(Integer asientosLibres) {
		this.asientosLibres = asientosLibres;
	}

	public Integer getNro_asientos() {
		return nro_asientos;
	}

	public void setNro_asientos(Integer nro_asientos) {
		this.nro_asientos = nro_asientos;
	}

	public Integer getNro_filas() {
		return nro_filas;
	}

	public void setNro_filas(Integer nro_filas) {
		this.nro_filas = nro_filas;
	}

	public String toString() {
		return "EspectaculoDTO [nombre=" + nombre + ", monto=" + monto + ", asientos_libres=" + asientosLibres + "]";
	}*/
}
