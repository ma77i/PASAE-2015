package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 12/6/15.
 */
public class AsientoDTO {

	private Long id;

	private Long filaId;

	private Integer numero;

	private Boolean ocupado;


	@JsonCreator
	public AsientoDTO(@JsonProperty("id") Long id, @JsonProperty("filaId") Long filaId, @JsonProperty("numero") Integer numero, @JsonProperty("ocupado") Boolean ocupado) {
		this.setId(id);
		this.setFilaId(filaId);
		this.setNumero(numero);
		this.setOcupado(ocupado);
	}


	public Long getFilaId() {
		return filaId;
	}

	public void setFilaId(Long filaId) {
		this.filaId = filaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
