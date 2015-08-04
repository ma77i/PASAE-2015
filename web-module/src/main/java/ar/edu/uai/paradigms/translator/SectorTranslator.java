package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Fila;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dto.SectorDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by EzequielPanoff on 9/6/15.
 */
public class SectorTranslator {

	public Sector translate(SectorDTO sectorDTO) {

		Collection<Fila> filas = new ArrayList<Fila>();
		Collection coleccion = sectorDTO.getFilas();
		for (Iterator iterator = coleccion.iterator(); iterator.hasNext(); ) {
			HashMap h = (HashMap) iterator.next();
			Iterator it = h.entrySet().iterator();
			while (it.hasNext()) {
				HashMap.Entry pairs = (HashMap.Entry) it.next();
				Fila fila = new Fila((Integer) pairs.getKey(), (Collection<Asiento>) pairs.getValue());
				filas.add(fila);
			}
		}
		return new Sector(sectorDTO.getNombre(), sectorDTO.getMonto(), filas);
	}

	public SectorDTO translateToDTO(Sector sector) {
		//return new SectorDTO(sector.getId(), sector.getNombre(), sector.getMonto(), sector.isAgotado(), sector.getEspectaculo().getId(),sector.getFilas());
		return null;
	}
}
