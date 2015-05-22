package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Empleado;
import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dto.EmpleadoDTO;

public class EmpleadoTranslator {
	
	public Empleado translate(EmpleadoDTO empleadoDTO) {
		return new Empleado(null, null, empleadoDTO.getName(),empleadoDTO.getApellido());
	}

	public EmpleadoDTO translateToDTO(Empleado usuario) {
		return new EmpleadoDTO(null, null, usuario.getNombre(),usuario.getApellido());
	}

}
