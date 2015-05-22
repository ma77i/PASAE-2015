package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Administrador;
import ar.edu.uai.paradigms.dto.AdministradorDTO;



public class AdministradorTranslator {

	public Administrador translate(AdministradorDTO espectadorDTO) {
		return new Administrador(null, null, espectadorDTO.getName(),espectadorDTO.getApellido());
	}

	public AdministradorDTO translateToDTO(Administrador espectador) {
		return new AdministradorDTO(null, null, espectador.getNombre(),espectador.getApellido());
	}
	
	
}
