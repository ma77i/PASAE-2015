package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.paradigms.dto.AsientoDTO;

/**
 * Created by EzequielPanoff on 13/6/15.
 */
public class AsientoTranslator {

	public Asiento translate(AsientoDTO asientoDTO) {
	//	return new Asiento(asientoDTO.getNumero());
		return null;
	}
	public AsientoDTO translateToDTO(Asiento asiento) {
		return new AsientoDTO(asiento.getId(), asiento.getFila().getId(), asiento.getNumero(), asiento.isOcupado());

	}
}
