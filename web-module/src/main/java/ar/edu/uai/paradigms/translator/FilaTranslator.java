package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Fila;
import ar.edu.uai.paradigms.dto.FilaDTO;

/**
 * Created by EzequielPanoff on 31/7/15.
 */
public class FilaTranslator {

    public Fila translate(FilaDTO filaDTO) {
        return new Fila();
        //return new Fila(filaDTO.getId(), filaDTO.getNro_fila(), filaDTO.getCantidad_asientos());
    }

    public FilaDTO translateToDTO(Fila fila) {
        //return new FilaDTO(fila.getId(), fila.getSector().getId(), fila.getNro_fila(), fila.getCantidad_asientos());
        return null;
    }
}
