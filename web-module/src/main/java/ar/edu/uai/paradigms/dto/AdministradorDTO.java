package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdministradorDTO extends UsuarioDTO {


	@JsonCreator
	public AdministradorDTO(@JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("nombre") String nombre,
							@JsonProperty("apellido") String apellido, @JsonProperty("estado") boolean estado) {
		super(email, password, nombre, apellido, estado);

	}

	@Override
	public String toString() {
		return "AdministradorDTO [email=" + this.getEmail() + ", password=" + this.getPassword() + ", nombre=" + this.getNombre() + ",apellido=" + this.getApellido() + "]";
	}
	
	
}
