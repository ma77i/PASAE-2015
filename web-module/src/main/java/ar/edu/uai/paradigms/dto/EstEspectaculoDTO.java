package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Matias on 03/10/2015.
 */
public class EstEspectaculoDTO {

    private Long cantidad;

    private String nombreEspectaculo;


    @JsonCreator
    public EstEspectaculoDTO(@JsonProperty("espectaculo") String espectaculo,@JsonProperty("cantidad")Long cantidad){
        this.setNombreEspectaculo(espectaculo);
        this.setCantidad(cantidad);
    }


    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }

    public void setNombreEspectaculo(String nombreEspectaculo) {
        this.nombreEspectaculo = nombreEspectaculo;
    }
}
