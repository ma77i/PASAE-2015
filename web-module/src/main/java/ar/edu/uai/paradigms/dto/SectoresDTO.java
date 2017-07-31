package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by Matias on 08/08/2015.
 */

public class SectoresDTO {

    private Collection<SectorDTO> sectores;
    private Long idFuncion;

    @JsonCreator
    public SectoresDTO(@JsonProperty("sectores") Collection<SectorDTO> sectores, @JsonProperty("idFuncion") Long idFuncion) {
        this.setSectores(sectores);
        this.setIdFuncion(idFuncion);
    }

    public Collection<SectorDTO> getSectores() {
        return sectores;
    }

    public void setSectores(Collection<SectorDTO> sectores) {
        this.sectores = sectores;
    }

	public Long getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(Long idFuncion) {
		this.idFuncion = idFuncion;
	}

}
