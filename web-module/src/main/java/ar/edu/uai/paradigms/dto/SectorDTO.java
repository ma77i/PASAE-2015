package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class SectorDTO {

    private String nombre;
    private Float monto;
    private long id_espectaculo; //VA ACA????
    private Integer asientosLibres;

    @JsonCreator
    public SectorDTO(@JsonProperty("nombre") String nombre, @JsonProperty("monto")Float monto, @JsonProperty("id_espectaculo") long id_espectaculo, @JsonProperty("asientosLibres") Integer asientosLibres) {
        this.nombre = nombre;
        this.monto = monto;
        this.id_espectaculo=id_espectaculo;
        this.asientosLibres=asientosLibres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public long getEspectaculo() {
        return id_espectaculo;
    }

    public void setEspectaculo(long id_espectaculo) {
        this.id_espectaculo = id_espectaculo;
    }

    public Integer getAsientosLibres() {
        return asientosLibres;
    }

    public void setAsientosLibres(Integer asientosLibres) {
        this.asientosLibres = asientosLibres;
    }

    public String toString() {
        return "EspectaculoDTO [nombre=" + nombre + ", monto=" + monto + ", asientos_libres=" + asientosLibres + "]";
    }
}
