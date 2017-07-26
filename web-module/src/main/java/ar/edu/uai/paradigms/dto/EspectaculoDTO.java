package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class EspectaculoDTO {

	private Long id;
	private String nombre;
	private String descripcion;
	private long categoriaId;
	private long teatroId;
	private MultipartFile imagen;
	private byte[] bytesImagen;
	private MultipartFile imagen_portada;
	private byte[] bytesImagenPortada;

	@JsonCreator
	public EspectaculoDTO(@JsonProperty("id") Long id, @JsonProperty("nombre") String nombre, @JsonProperty("descripcion") String descripcion, @JsonProperty("categoriaId") long categoria, @JsonProperty("teatroId") long teatroId, @JsonProperty("imagen") MultipartFile imagen, @JsonProperty("bytesimagen") byte[] bytesImagen, @JsonProperty("imagenportada") MultipartFile imagen_portada, @JsonProperty("bytesimagenportada") byte[] bytesImagenPortada) {
		this.setId(id);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setCategoriaId(categoria);
		this.setTeatroId(teatroId);
		this.setImagen(imagen);
		this.setBytesImagen(bytesImagen);
		this.setImagen_portada(imagen_portada);
		this.setBytesImagenPortada(bytesImagenPortada);


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

	public MultipartFile getImagen() {
		return imagen;
	}

	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}

	public byte[] getBytesImagen() {
		return bytesImagen;
	}

	public void setBytesImagen(byte[] bytesImagen) {
		this.bytesImagen = bytesImagen;
	}

	public MultipartFile getImagen_portada() {
		return imagen_portada;
	}

	public void setImagen_portada(MultipartFile imagen_portada) {
		this.imagen_portada = imagen_portada;
	}

	public byte[] getBytesImagenPortada() {
		return bytesImagenPortada;
	}

	public void setBytesImagenPortada(byte[] bytesImagenPortada) {
		this.bytesImagenPortada = bytesImagenPortada;
	}



	public String toString() {
		return "EspectaculoDTO [nombre=" + nombre + ", descripcion=" + descripcion + ", categoriaId=" + categoriaId + ",teatroId=" + teatroId + ",imagen="+imagen+ "]";

	}
}
