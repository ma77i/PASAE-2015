package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class EspectaculoDTO {

	private String nombre;
	private String descripcion;
	private Long categoriaId;
	private Long teatroId;

	@JsonCreator
	public EspectaculoDTO(@JsonProperty("nombre") String nombre, @JsonProperty("descripcion") String descripcion, @JsonProperty("categoriaId") Long categoriaId, @JsonProperty("teatroId") Long teatroId) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoriaId = categoriaId;
		this.teatroId = teatroId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Long getTeatroId() {
		return teatroId;
	}

	public void setTeatroId(Long teatroId) {
		this.teatroId = teatroId;
	}

	public String toString() {
		return "EspectaculoDTO [nombre=" + nombre + ", descripcion=" + descripcion + ", categoriaId=" + categoriaId + ",teatroId=" + teatroId + "]";

	}
}
