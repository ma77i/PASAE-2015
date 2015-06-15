package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Empleado;
import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dto.EmpleadoDTO;

public class EmpleadoTranslator {
	
	public Empleado translate(EmpleadoDTO empleadoDTO) {
		return new Empleado(empleadoDTO.getEmail(), empleadoDTO.getPassword(), empleadoDTO.getName(),empleadoDTO.getApellido(),empleadoDTO.getUsuario());
	}

	public EmpleadoDTO translateToDTO(Empleado usuario) {
		return new EmpleadoDTO(usuario.getEmail(), usuario.getPassword(), usuario.getNombre(),usuario.getApellido(),usuario.getUsuario());
	}

}
