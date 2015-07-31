package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Administrador;
import ar.edu.uai.paradigms.dto.AdministradorDTO;

public class AdministradorTranslator {

	public Administrador translate(AdministradorDTO administradorDTO) {
		return new Administrador(administradorDTO.getEmail(), administradorDTO.getPassword(), administradorDTO.getNombre(), administradorDTO.getApellido());
	}

	public AdministradorDTO translateToDTO(Administrador usuario) {
		return new AdministradorDTO(usuario.getId(), usuario.getEmail(), usuario.getPassword(), usuario.getNombre(), usuario.getApellido(), usuario.getEstado());
	}

}
