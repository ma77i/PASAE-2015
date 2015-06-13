package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.paradigms.dto.AsientoDTO;

/**
 * Created by EzequielPanoff on 13/6/15.
 */
public class AsientoTranslator {

    public Asiento translate(AsientoDTO asientoDTO) {
        return new Asiento(asientoDTO.getFila(), asientoDTO.getNumero(), asientoDTO.isOcupado(), asientoDTO.getSector());
    }

    public AsientoDTO translateToDTO(Asiento asiento) {
        return new AsientoDTO(asiento.getFila(),asiento.getNumero(),asiento.isOcupado(), asiento.getSector());
    }
}
