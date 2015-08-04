package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Fila;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dto.AsientoDTO;
import ar.edu.uai.paradigms.dto.FilaDTO;
import ar.edu.uai.paradigms.dto.SectorDTO;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class SectorTranslator {

	public Sector translate(SectorDTO sectorDTO) {
		Collection<Fila> filas = new ArrayList<Fila>();
		for (FilaDTO e : sectorDTO.getFilas()) {
			Collection<AsientoDTO> asientosDTO = e.getAsientos();
			Collection<Asiento> asientos = new ArrayList<Asiento>();
			for (AsientoDTO a : e.getAsientos()) {
				asientos.add(new Asiento(a.getNumero()));
			}
			filas.add(new Fila(e.getNro_fila(), asientos));
		}

		return new Sector(sectorDTO.getNombre(), sectorDTO.getMonto(), filas);

	}

	public SectorDTO translateToDTO(Sector sector) {


		return null;


		//return new SectorDTO(sector.getId(), sector.getNombre(), sector.getMonto(), sector.isAgotado(), sector.getEspectaculo().getId(),sector.getFilas());

	}
}
