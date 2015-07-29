package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpleadoDTO extends UsuarioDTO {


	@JsonCreator
	public EmpleadoDTO(@JsonProperty("id") Long id, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("nombre") String nombre,
					   @JsonProperty("apellido") String apellido, @JsonProperty("estado") String estado) {
		super(id, email, password, nombre, apellido, estado);
	}

	@Override
	public String toString() {
		return "EmpleadoDTO [email=" + this.getEmail() + ", password=" + this.getPassword() + ", nombre=" + this.getNombre() + ",apellido=" + this.getApellido() + "]";
	}

}