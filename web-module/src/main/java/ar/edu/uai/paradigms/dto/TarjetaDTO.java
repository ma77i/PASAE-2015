package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Matias on 22/06/2015.
 */
public class TarjetaDTO {
    private String nro_tarjeta;
    private int cvv;
    private Date fecha_vencimiento;


    @JsonCreator
    public TarjetaDTO(@JsonProperty("nro") String nro_tarjeta, @JsonProperty("cvv") int cvv, @JsonProperty("fecha_vencimiento") Date fecha_vencimiento) {
        this.setNro(nro_tarjeta);
        this.setCvv(cvv);
        this.setFecha_vencimiento(fecha_vencimiento);

    }

    public String getNro() {
        return nro_tarjeta;
    }

    public void setNro(String nro) {
        this.nro_tarjeta = nro;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
}
