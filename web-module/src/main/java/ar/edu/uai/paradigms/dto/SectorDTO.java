package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class SectorDTO {

	private Long id;
	private String nombre;
	private Long monto;
	private Boolean agotado;
	private Collection<FilaDTO> filas;


	//private Integer asientosLibres;
	//private Integer nro_asientos;
	//private Integer nro_filas;
	private Long funcionId;

	@JsonCreator
	public SectorDTO(@JsonProperty("id") Long id, @JsonProperty("nombre") String nombre, @JsonProperty("monto") Long monto, @JsonProperty("agotado") Boolean agotado, @JsonProperty("funcionId") Long funcionId, @JsonProperty("filas") Collection<FilaDTO> filas) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setMonto(monto);
		this.setAgotado(agotado);
		this.setFuncionId(funcionId);
		this.setFilas(filas);
	}


	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public Boolean getAgotado() {
		return agotado;
	}

	public void setAgotado(Boolean agotado) {
		this.agotado = agotado;
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

	public Collection<FilaDTO> getFilas() {
		return filas;
	}

	public void setFilas(Collection<FilaDTO> filas) {
		this.filas = filas;
	}


	public Long getFuncionId() {
		return funcionId;
	}


	public void setFuncionId(Long funcionId) {
		this.funcionId = funcionId;
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
