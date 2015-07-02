package ar.edu.uai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Matias on 24/06/2015.
 */

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titular;
    private String titular_DNI;
    private String nro_tarjeta;
    private String CVV;
    private Float monto;
    private String resultado;


    public Transaccion(String titular, String titular_DNI, String nro_tarjeta, String CVV, Float monto, String resultado) {
        this.titular = titular;
        this.titular_DNI = titular_DNI;
        this.nro_tarjeta = nro_tarjeta;
        this.CVV = CVV;
        this.monto = monto;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return monto;
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
