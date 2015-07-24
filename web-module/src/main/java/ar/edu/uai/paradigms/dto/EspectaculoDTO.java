package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class EspectaculoDTO {

	private Long id;
	private String nombre;
	private String descripcion;
	private long categoriaId;
	private long teatroId;

	@JsonCreator
	public EspectaculoDTO(@JsonProperty("id") Long id, @JsonProperty("nombre") String nombre, @JsonProperty("descripcion") String descripcion, @JsonProperty("categoriaId") long categoria, @JsonProperty("teatroId") long teatroId) {
		this.setId(id);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setCategoriaId(categoria);
		this.setTeatroId(teatroId);
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public long getTeatroId() {
		return teatroId;
	}

	public void setTeatroId(long teatroId) {
		this.teatroId = teatroId;
	}

	public String toString() {
		return "EspectaculoDTO [nombre=" + nombre + ", descripcion=" + descripcion + ", categoriaId=" + categoriaId + ",teatroId=" + teatroId + "]";

	}
}
