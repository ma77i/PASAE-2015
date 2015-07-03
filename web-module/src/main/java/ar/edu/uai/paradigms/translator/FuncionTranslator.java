package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.dto.FuncionDTO;
import ar.edu.uai.paradigms.service.EspectaculoService;

public class FuncionTranslator {
    EspectaculoService espectaculoService;


    public void setEspectaculoService(EspectaculoService espectaculoService) {
        this.espectaculoService = espectaculoService;
    }


    public Funcion translate(FuncionDTO funcionDTO) {
        return new Funcion(funcionDTO.getFecha(), funcionDTO.getHora(), this.espectaculoService.retrieveEspectaculo(funcionDTO.getEspectaculoId()));

    }

    public FuncionDTO translateToDTO(Funcion funcion) {
        return new FuncionDTO(funcion.getFecha(), funcion.getHora(), funcion.getEspectaculo().getId());
    }


}
