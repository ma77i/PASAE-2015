package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Matias on 29/06/2015.
 */
public class TeatroDTO {

    private String nombre;

    private String direccion;

    private String cuit;

    private String propietario;

    private Long id;

    @JsonCreator
    public TeatroDTO(@JsonProperty("nombre") String nombre, @JsonProperty("direccion") String direccion, @JsonProperty("id") Long id,  @JsonProperty("cuit") String cuit, @JsonProperty("propietario") String propietario) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setId(id);
        this.setCuit(cuit);
        this.setPropietario(propietario);
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

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}