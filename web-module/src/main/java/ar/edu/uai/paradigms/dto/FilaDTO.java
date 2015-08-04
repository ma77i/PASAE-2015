package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by EzequielPanoff on 31/7/15.
 */
public class FilaDTO {

    private Long id;

    private Integer nro_fila;

    private Long sectorId;

    // private Integer cantidad_asientos;

    private Collection<AsientoDTO> asientos;

    @JsonCreator
    public FilaDTO(@JsonProperty("id") Long id, @JsonProperty("sectorId") Long sectorId, @JsonProperty("nro_fila") Integer nro_fila, @JsonProperty("asientos") Collection<AsientoDTO> asientos) {
        super();
        this.setId(id);
        this.setSectorId(sectorId);
        this.setNro_fila(nro_fila);
        this.setAsientos(asientos);

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSectorId() {
        return sectorId;
    }

    public void setSectorId(Long sectorId) {
        this.sectorId = sectorId;
    }

    public Integer getNro_fila() {
        return nro_fila;
    }

    public void setNro_fila(Integer nro_fila) {
        this.nro_fila = nro_fila;
    }

    public Collection<AsientoDTO> getAsientos() {
        return asientos;
    }

    public void setAsientos(Collection<AsientoDTO> asientos) {
        this.asientos = asientos;
    }

    /*public Integer getCantidad_asientos() {
        return cantidad_asientos;
    }

    public void setCantidad_asientos(Integer cantidad_asientos) {
        this.cantidad_asientos = cantidad_asientos;
    }*/
}
