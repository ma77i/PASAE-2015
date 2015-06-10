package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class EspectaculoDTO {

    private String nombre;
    private String descripcion;

    @JsonCreator
    public EspectaculoDTO(@JsonProperty("nombre") String nombre, @JsonProperty("descripcion")String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String toString() {
        return "EspectaculoDTO [nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }

}
