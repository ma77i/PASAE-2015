package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.paradigms.dto.EspectaculoDTO;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class EspectaculoTranslator {

	public Espectaculo translate(EspectaculoDTO espectaculoDTO) {

		return new Espectaculo(espectaculoDTO.getNombre(), espectaculoDTO.getDescripcion());
	}

	public EspectaculoDTO translateToDTO(Espectaculo espectaculo)  {

		CommonsMultipartFile file=new CommonsMultipartFile(null);
		return new EspectaculoDTO(espectaculo.getId(), espectaculo.getNombre(), espectaculo.getDescripcion(), espectaculo.getCategoria().getId(), espectaculo.getTeatro().getId(),file);
	}

}

