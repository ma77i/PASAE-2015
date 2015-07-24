package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpleadoDTO extends UsuarioDTO {


	@JsonCreator
	public EmpleadoDTO(@JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("nombre") String nombre,
					   @JsonProperty("apellido") String apellido) {
		super(email, password, nombre, apellido);
	}

	@Override
	public String toString() {
		return "EmpleadoDTO [email=" + this.getEmail() + ", password=" + this.getPassword() + ", nombre=" + this.getNombre() + ",apellido=" + this.getApellido() + "]";
	}

}