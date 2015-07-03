package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Matias on 30/06/2015.
 */
public class CategoriaDTO {

    private String nombre;


    @JsonCreator
    public CategoriaDTO(@JsonProperty("nombre") String nombre) {
        super();
        this.setNombre(nombre);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
