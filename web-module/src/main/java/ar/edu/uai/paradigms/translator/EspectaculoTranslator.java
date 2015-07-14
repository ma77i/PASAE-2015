package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.paradigms.dto.EspectaculoDTO;
import ar.edu.uai.paradigms.service.CategoriaService;
import ar.edu.uai.paradigms.service.TeatroService;

public class EspectaculoTranslator {

	public Espectaculo translate(EspectaculoDTO espectaculoDTO) {
		return new Espectaculo(espectaculoDTO.getNombre(), espectaculoDTO.getDescripcion());
	}

	public EspectaculoDTO translateToDTO(Espectaculo espectaculo) {
		return new EspectaculoDTO(espectaculo.getNombre(), espectaculo.getDescripcion(), espectaculo.getCategoria().getId(), espectaculo.getTeatro().getId());
	}

}

