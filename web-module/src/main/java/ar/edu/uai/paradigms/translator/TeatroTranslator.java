package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Teatro;
import ar.edu.uai.paradigms.dto.TeatroDTO;

/**
 * Created by Matias on 08/07/2015.
 */
public class TeatroTranslator {

    public Teatro translate(TeatroDTO teatroDTO) {
        return new Teatro(teatroDTO.getNombre(), teatroDTO.getDireccion(),teatroDTO.getCuit(),teatroDTO.getPropietario());
    }

    public TeatroDTO translateToDTO(Teatro teatro) {
        return new TeatroDTO(teatro.getNombre(), teatro.getDireccion(), teatro.getId(),teatro.getCuit(),teatro.getPropietario());
    }


}
