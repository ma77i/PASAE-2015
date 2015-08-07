package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Empleado;
import ar.edu.uai.paradigms.dto.EmpleadoDTO;

public class EmpleadoTranslator {

	public Empleado translate(EmpleadoDTO empleadoDTO) {
		return new Empleado(empleadoDTO.getEmail(), empleadoDTO.getPassword(), empleadoDTO.getNombre(), empleadoDTO.getApellido());
	}

	public EmpleadoDTO translateToDTO(Empleado usuario) {
		return new EmpleadoDTO(usuario.getId(), usuario.getEmail(), usuario.getPassword(), usuario.getNombre(), usuario.getApellido(), usuario.getEstado());
	}

}
