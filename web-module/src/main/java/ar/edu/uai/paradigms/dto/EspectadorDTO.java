package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */
public class EspectadorDTO {
	
	private String email;
	private String password;
	private String nombre;
	private String apellido;

	@JsonCreator
	public EspectadorDTO(@JsonProperty("email")String email, @JsonProperty("password")String password, @JsonProperty("nombre")String nombre, @JsonProperty("apellido")String apellido) {
		super();
		this.setEmail(email);
		this.setPassword(password);
		this.nombre = nombre;
		this.apellido= apellido;
	}

	

	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "EspectadorDTO [nombre=" + nombre + ", age=" + apellido + "]";
	}


}
