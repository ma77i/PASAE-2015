package ar.edu.uai.paradigms.dto;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Funcion;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Matias on 10/06/2015.
 */
public class VentaDTO {
    private float monto;
    private float costoAdicional;
    private Date fechaVenta;
    private int cuotas;
    private Funcion funcion; //VA ACA
    private Espectador comprador; //VA ACA

    @JsonCreator
    public VentaDTO(@JsonProperty("monto")float monto, @JsonProperty("costoAdicional")float costoAdicional, @JsonProperty("fechaVenta") Date fechaVenta,@JsonProperty("cuotas") int cuotas,@JsonProperty("Funcion") Funcion funcion,@JsonProperty("comprador") Espectador comprador) {
        super();
        this.setMonto(monto);
        this.setCostoAdicional(costoAdicional);
        this.setFechaVenta(fechaVenta);
        this.setCuotas(cuotas);
        this.setFuncion(funcion);
        this.setComprador(comprador);
    }


    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(float costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Espectador getComprador() {
        return comprador;
    }

    public void setComprador(Espectador comprador) {
        this.comprador = comprador;
    }
    public String toString() {
        return "VentaDTO [monto=" + monto + ", costoAdicional=" + costoAdicional + ", fechaVenta=" + fechaVenta + ",cuotas=" + cuotas +  "]"; //ACA VA LA FUNCION Y ESPECTACULO ?
    }

}
