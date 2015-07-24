package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */
public class EspectadorDTO extends UsuarioDTO {



	@JsonCreator
	public EspectadorDTO(@JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("nombre") String nombre,
						 @JsonProperty("apellido") String apellido) {
		super(email, password, nombre, apellido);

	}

	@Override
	public String toString() {
		return "EspectadorDTO [email=" + this.getEmail() + ", password=" + this.getPassword() + ", nombre=" + this.getNombre() + ",apellido=" + this.getApellido() + "]";
	}

}
