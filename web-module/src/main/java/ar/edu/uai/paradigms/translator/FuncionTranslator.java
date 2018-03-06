package ar.edu.uai.paradigms.translator;

import java.util.ArrayList;
import java.util.Collection;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dto.FuncionDTO;
import ar.edu.uai.paradigms.dto.SectorDTO;

public class FuncionTranslator {
	
	private SectorTranslator sectorTranslator;
	
	public FuncionTranslator(SectorTranslator sectorTranslator) {
        this.sectorTranslator = sectorTranslator;
    }

    public Funcion translate(FuncionDTO funcionDTO) {
    	Collection<Sector> sectores = new ArrayList<Sector>();
    	Espectaculo espectaculo = new Espectaculo();
    	espectaculo.setId(funcionDTO.getEspectaculoId());
		for (SectorDTO s : funcionDTO.getSectores()) {
			sectores.add(this.sectorTranslator.translate(s));
		}
		Funcion funcion = new Funcion(funcionDTO.getFecha(), funcionDTO.getHora(), sectores);
		funcion.setEspectaculo(espectaculo);
        return funcion;
    }

    public FuncionDTO translateToDTO(Funcion funcion) {
    	Collection<SectorDTO> sectores = new ArrayList<SectorDTO>();
		for (Sector s : funcion.getSectores()) {
			s.setFuncion(funcion);
			sectores.add(sectorTranslator.translateToDTO(s));
		}
    	return new FuncionDTO(funcion.getId(), funcion.getFecha(), funcion.getHora(), funcion.getEspectaculo().getId(), sectores);
    }

	public SectorTranslator getSectorTranslator() {
		return sectorTranslator;
	}

	public void setSectorTranslator(SectorTranslator sectorTranslator) {
		this.sectorTranslator = sectorTranslator;
	}
}
