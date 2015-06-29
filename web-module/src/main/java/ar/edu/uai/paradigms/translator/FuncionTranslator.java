package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.dto.FuncionDTO;
import ar.edu.uai.paradigms.service.EspectaculoService;

public class FuncionTranslator {
    EspectaculoService espectaculoService;


    public void setEspectaculoService(EspectaculoService espectaculoService) {
        this.espectaculoService = espectaculoService;
    }


    public Funcion translate(FuncionDTO funcionDTO) {
        Espectaculo espectaculo = this.espectaculoService.retrieveEspectaculo(funcionDTO.getEspectaculoId());
        return new Funcion(funcionDTO.getFecha(), funcionDTO.getHora(), espectaculo);

    }

    public FuncionDTO translateToDTO(Funcion funcion) {
        return new FuncionDTO(funcion.getFecha(), funcion.getHora(), funcion.getEspectaculo().getId());
    }


}
