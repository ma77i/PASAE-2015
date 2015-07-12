package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Matias on 30/06/2015.
 */
public class CategoriaDTO {

    private String nombre;
    private Long id;

    public Long getId() {
        return id;
    }

    @JsonCreator
    public CategoriaDTO(@JsonProperty("nombre") String nombre, @JsonProperty("id") Long id) {
        super();
        this.setNombre(nombre);
        this.setId(id);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
