package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dto.EspectadorDTO;



public class EspectadorTranslator {

	public Espectador translate(EspectadorDTO espectadorDTO) {
		return new Espectador(null, null, espectadorDTO.getName(),espectadorDTO.getApellido());
	}

	public EspectadorDTO translateToDTO(Espectador usuario) {
		return new EspectadorDTO(null, null, usuario.getNombre(),usuario.getApellido());
	}
}
