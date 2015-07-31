package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by EzequielPanoff on 31/7/15.
 */
public class FilaDTO {

    private Long id;



    private Integer nro_fila;

    private Long sectorId;


    @JsonCreator
    public FilaDTO(@JsonProperty("id") Long id, @JsonProperty("sectorId") Long sectorId, @JsonProperty("nro_fila") Integer nro_fila) {
        super();
        this.setId(id);
        this.setSectorId(sectorId);
        this.setNro_fila(nro_fila);

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
}
