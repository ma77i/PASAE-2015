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
		Sector sector=new Sector(sectorDTO.getNombre(),sectorDTO.getMonto());

		for (FilaDTO f : sectorDTO.getFilas()) {
			Collection<Asiento> asientos = new ArrayList<Asiento>();
			Fila fila=new Fila(f.getNro_fila());
			for (AsientoDTO a : f.getAsientos()) {
				asientos.add(new Asiento(a.getNumero(),fila));
			}
			fila.setAsientos(asientos);
			fila.setSector(sector);
			filas.add(fila);
		}
		sector.setFilas(filas);;
		return sector;

	}

	public SectorDTO translateToDTO(Sector sector) {

		Collection<FilaDTO> filasDTO = new ArrayList<FilaDTO>();
		for (Fila f : sector.getFilas()) {
			Collection<AsientoDTO> asientosDTO = new ArrayList<AsientoDTO>();
			for (Asiento a : f.getAsientos()) {
				asientosDTO.add(new AsientoDTO(a.getId(),a.getFila().getId(),a.getNumero(),a.isOcupado()));
			}
			filasDTO.add(new FilaDTO(f.getId(), f.getSector().getId(),f.getNro_fila(),asientosDTO));
		}


		return new SectorDTO(sector.getId(), sector.getNombre(), sector.getMonto(), sector.isAgotado(), sector.getFuncion().getId(),filasDTO);

	}
}
