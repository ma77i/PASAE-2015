package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 29/6/15.
 */
public abstract class UsuarioDTO {

    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private Boolean estado;


    @JsonCreator
    public UsuarioDTO(@JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("nombre") String nombre,
                      @JsonProperty("apellido") String apellido) {
        this.email=email;
        this.password=password;
        this.nombre = nombre;
        this.apellido = apellido;
        //  this.estado = estado;

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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public abstract String toString();


}
