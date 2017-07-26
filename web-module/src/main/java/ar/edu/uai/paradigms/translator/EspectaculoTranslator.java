package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.paradigms.dto.EspectaculoDTO;

import java.io.FileNotFoundException;
import java.sql.SQLException;


public class EspectaculoTranslator {

	public Espectaculo translate(EspectaculoDTO espectaculoDTO) {

		return new Espectaculo(espectaculoDTO.getNombre(), espectaculoDTO.getDescripcion());
	}

	public EspectaculoDTO translateToDTO(Espectaculo espectaculo) throws SQLException, FileNotFoundException {
		byte [] bytesImagen=espectaculo.getImagen().getBytes(1,(int)espectaculo.getImagen().length());
		byte [] bytesImagenPortada=espectaculo.getImagen_portada().getBytes(1,(int)espectaculo.getImagen_portada().length());
		return new EspectaculoDTO(espectaculo.getId(), espectaculo.getNombre(), espectaculo.getDescripcion(), espectaculo.getCategoria().getId(), espectaculo.getTeatro().getId(),null,bytesImagen,null,bytesImagenPortada);
	}

}

