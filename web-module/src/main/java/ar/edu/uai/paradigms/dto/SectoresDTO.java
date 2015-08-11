package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by Matias on 08/08/2015.
 */

public class SectoresDTO {

    private Collection<SectorDTO> sectores;
    private Long idEspectaculo;

    @JsonCreator
    public SectoresDTO(@JsonProperty("sectores") Collection<SectorDTO> sectores, @JsonProperty("espectaculoId") Long idEspectaculo) {
        this.setSectores(sectores);
        this.setIdEspectaculo(idEspectaculo);
    }

    public Collection<SectorDTO> getSectores() {
        return sectores;
    }

    public void setSectores(Collection<SectorDTO> sectores) {
        this.sectores = sectores;
    }

    public Long getIdEspectaculo() {
        return idEspectaculo;
    }

    public void setIdEspectaculo(Long idEspectaculo) {
        this.idEspectaculo = idEspectaculo;
    }
}
