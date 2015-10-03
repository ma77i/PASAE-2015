package ar.edu.uai.paradigms.controller;

import ar.edu.uai.paradigms.dto.FilaDTO;
import ar.edu.uai.paradigms.service.FilaService;
import ar.edu.uai.paradigms.translator.FilaTranslator;
import ar.edu.uai.paradigms.validators.FilaDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by EzequielPanoff on 31/7/15.
 */

@Controller
@RequestMapping("/fila")
public class
        FilaController {


    private static final Logger LOGGER = LoggerFactory.getLogger(FilaController.class);

    private FilaService filaService;

    private FilaTranslator filaTranslator;

    public FilaController(FilaService filaService, FilaTranslator filaTranslator) {
        this.filaService = filaService;
        this.filaTranslator = filaTranslator;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new FilaDTOValidator());
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    FilaDTO createFila(@RequestBody @Valid FilaDTO filaDTO) {
        LOGGER.debug("Received DTO: " + filaDTO);
        return null;
        // return this.filaTranslator.translateToDTO(this.filaService.saveFila(this.filaTranslator.translate(filaDTO), filaDTO.getSectorId(), filaDTO.getCantidad_asientos()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public @ResponseBody FilaDTO getFila(@PathVariable long identifier) {
        return this.filaTranslator.translateToDTO((this.filaService.retrieveFila(identifier)));
    }
}
