package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 29/6/15.
 */
public abstract class UsuarioDTO {
    private Long id;
    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private String estado;


    @JsonCreator
    public UsuarioDTO(@JsonProperty("id") Long id, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("nombre") String nombre,
                      @JsonProperty("apellido") String apellido, @JsonProperty("estado") String estado) {
        this.id = id;
        this.email=email;
        this.password=password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public abstract String toString();


}
