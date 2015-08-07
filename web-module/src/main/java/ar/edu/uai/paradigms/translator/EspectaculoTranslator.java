package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.paradigms.dto.EspectaculoDTO;

public class EspectaculoTranslator {

	public Espectaculo translate(EspectaculoDTO espectaculoDTO) {
		return new Espectaculo(espectaculoDTO.getNombre(), espectaculoDTO.getDescripcion(), espectaculoDTO.getImagen());
	}

	public EspectaculoDTO translateToDTO(Espectaculo espectaculo) {
		return new EspectaculoDTO(espectaculo.getId(), espectaculo.getNombre(), espectaculo.getDescripcion(), espectaculo.getCategoria().getId(), espectaculo.getTeatro().getId(),espectaculo.getImagen());
	}

}

