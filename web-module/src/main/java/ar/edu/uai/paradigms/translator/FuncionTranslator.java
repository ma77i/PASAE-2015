package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.dto.FuncionDTO;

public class FuncionTranslator {

    public Funcion translate(FuncionDTO funcionDTO) {
        return new Funcion(funcionDTO.getFecha());

    }

    public FuncionDTO translateToDTO(Funcion funcion) {
        return new FuncionDTO(funcion.getId(), funcion.getFecha(), funcion.getEspectaculo().getId());
    }


}
