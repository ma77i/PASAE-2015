package ar.edu.uai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {

	

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;

	private String email;

	private String password;

	private String nombre;

	private String apellido;
	
	private String usuario;
	
	public Usuario(){
		
	}
	
	
	public Usuario(String email, String password, String nombre,
			String apellido,String usuario) {
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario=usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
    
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
