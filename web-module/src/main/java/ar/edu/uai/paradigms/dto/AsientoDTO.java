package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 12/6/15.
 */
public class AsientoDTO {

    private String fila;

    private int numero;

    private boolean ocupado;

    private long id_sector;

    @JsonCreator
    public AsientoDTO(@JsonProperty ("fila") String fila, @JsonProperty("numero") int numero, @JsonProperty ("ocupado") boolean ocupado, @JsonProperty ("id_sector") long id_sector) {
        this.fila = fila;
        this.numero = numero;
        this.ocupado = ocupado;
        this.id_sector = id_sector;
    }


    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public long getSector() {
        return id_sector;
    }

    public void setSector(long id_sector) {
        this.id_sector = id_sector;
    }

    public String toString() {
        return "AsientoDTO [fila=" + fila + ", numero=" + numero + ", ocupado=" + ocupado + "]";
    }
}
