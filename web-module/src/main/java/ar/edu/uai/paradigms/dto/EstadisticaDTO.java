package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Matias on 28/09/2015.
 */

public class EstadisticaDTO {

    private Long cantidad;

    private String mes;


    @JsonCreator
    public EstadisticaDTO(@JsonProperty("mes") String mes,@JsonProperty("cantidad")Long cantidad){
        this.setCantidad(cantidad);
        this.setMes(mes);

    }


    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
