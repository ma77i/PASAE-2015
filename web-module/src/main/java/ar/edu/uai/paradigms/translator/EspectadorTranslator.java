package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.paradigms.dto.EspectadorDTO;

public class EspectadorTranslator {

	public Espectador translate(EspectadorDTO espectadorDTO) {
		return new Espectador(espectadorDTO.getEmail(), espectadorDTO.getPassword(), espectadorDTO.getNombre(), espectadorDTO.getApellido());
	}

	public EspectadorDTO translateToDTO(Espectador usuario) {
		return new EspectadorDTO(usuario.getId(), usuario.getEmail(), usuario.getPassword(), usuario.getNombre(), usuario.getApellido(), usuario.getEstado());
	}
}
