package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Matias on 24/06/2015.
 */
public class TransaccionDTO {
    private String titular;
    private String titular_DNI;
    private String nro_tarjeta;
    private String CVV;
    private Float monto;
    private String resultado;


    @JsonCreator
    public TransaccionDTO(@JsonProperty("titular") String titular, @JsonProperty("titular_DNI") String titular_DNI, @JsonProperty("nro_tarjeta") String nro_tarjeta, @JsonProperty("CVV") String CVV, @JsonProperty("monto") Float monto, @JsonProperty("resultado") String resultado) {
        this.titular = titular;
        this.titular_DNI = titular_DNI;
        this.nro_tarjeta = nro_tarjeta;
        this.CVV = CVV;
        this.monto = monto;
        this.resultado = resultado;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitular_DNI() {
        return titular_DNI;
    }

    public void setTitular_DNI(String titular_DNI) {
        this.titular_DNI = titular_DNI;
    }

    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public Float getMonto() {
        return this.monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }


    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
