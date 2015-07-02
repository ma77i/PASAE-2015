package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.paradigms.dto.EspectaculoDTO;
import ar.edu.uai.paradigms.service.EspectaculoService;

public class EspectaculoTranslator {



	public Espectaculo translate(EspectaculoDTO espectaculoDTO) {

		return new Espectaculo(espectaculoDTO.getNombre(), espectaculoDTO.getDescripcion());
	}

	public EspectaculoDTO translateToDTO(Espectaculo espectaculo) {
		return new EspectaculoDTO(espectaculo.getNombre(), espectaculo.getDescripcion());
	}

}
