package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class SectorDTO {

	private String nombre;
	private Float monto;
	private Integer asientosLibres;
	private Integer nro_asientos;
	private Integer nro_filas;
	private Long id_espectaculo;

	@JsonCreator
	public SectorDTO(@JsonProperty("nombre") String nombre, @JsonProperty("monto") Float monto, @JsonProperty("id_espectaculo") Long id_espectaculo,
					 @JsonProperty("asientosLibres") Integer asientosLibres, @JsonProperty("nro_asientos") Integer nro_asientos, @JsonProperty("nro_filas") Integer nro_filas) {
		this.nombre = nombre;
		this.monto = monto;
		this.asientosLibres = asientosLibres;
		this.nro_asientos = nro_asientos;
		this.nro_filas = nro_filas;
		this.id_espectaculo = id_espectaculo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public long getEspectaculo() {
		return id_espectaculo;
	}

	public void setEspectaculo(Long id_espectaculo) {
		this.id_espectaculo = id_espectaculo;
	}

	public Integer getAsientosLibres() {
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
	}
}
