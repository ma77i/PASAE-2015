package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Matias on 29/06/2015.
 */
public class TeatroDTO {

    private String nombre;

    private String direccion;

    @JsonCreator
    public TeatroDTO(@JsonProperty("nombre") String nombre, @JsonProperty("direccion") String direccion) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}