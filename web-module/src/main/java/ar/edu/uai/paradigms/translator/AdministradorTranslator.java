package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Administrador;
import ar.edu.uai.paradigms.dto.AdministradorDTO;

public class AdministradorTranslator {

	public Administrador translate(AdministradorDTO administradorDTO) {
		return new Administrador(administradorDTO.getEmail(), administradorDTO.getPassword(), administradorDTO.getName(), administradorDTO.getApellido(),
				administradorDTO.getUsuario());
	}

	public AdministradorDTO translateToDTO(Administrador usuario) {
		return new AdministradorDTO(usuario.getEmail(), usuario.getPassword(), usuario.getNombre(), usuario.getApellido(), usuario.getUsuario());
	}

}
