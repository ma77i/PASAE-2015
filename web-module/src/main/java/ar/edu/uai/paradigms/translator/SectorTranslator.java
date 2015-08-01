package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dto.SectorDTO;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class SectorTranslator {

	public Sector translate(SectorDTO sectorDTO) {

		return new Sector(sectorDTO.getNombre(), sectorDTO.getMonto());
	}

	public SectorDTO translateToDTO(Sector sector) {
		return new SectorDTO(sector.getId(), sector.getNombre(), sector.getMonto(), sector.isAgotado(), sector.getEspectaculo().getId());
	}
}
