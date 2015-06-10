package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Administrador;
import ar.edu.uai.paradigms.dto.AdministradorDTO;



public class AdministradorTranslator {

	public Administrador translate(AdministradorDTO administradorDTO) {
		return new Administrador(null, null, administradorDTO.getName(),administradorDTO.getApellido());
	}

	public AdministradorDTO translateToDTO(Administrador usuario) {
		return new AdministradorDTO(null, null, usuario.getNombre(),usuario.getApellido());
	}
	
	
}
