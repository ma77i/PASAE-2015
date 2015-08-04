package ar.edu.uai.paradigms.controller;

import ar.edu.uai.paradigms.dto.AsientoDTO;
import ar.edu.uai.paradigms.service.AsientoService;
import ar.edu.uai.paradigms.translator.AsientoTranslator;
import ar.edu.uai.paradigms.validators.AsientoDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Matias on 31/07/2015.
 */

@Controller
@RequestMapping("/asiento")

public class AsientoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsientoController.class);

    private AsientoService asientoService;

    private AsientoTranslator asientoTranslator;

    public AsientoController(AsientoService asientoService, AsientoTranslator asientoTranslator) {
        this.asientoService = asientoService;
        this.asientoTranslator = asientoTranslator;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new AsientoDTOValidator());
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    AsientoDTO crearAsiento(@RequestBody @Valid AsientoDTO asientoDTO) {
        LOGGER.debug("Received DTO: " + asientoDTO);
        return this.asientoTranslator.translateToDTO(this.asientoService.saveAsiento(this.asientoTranslator.translate(asientoDTO), asientoDTO.getFilaId()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    AsientoDTO getAsiento(@PathVariable long identifier) {
        return this.asientoTranslator.translateToDTO((this.asientoService.retrieveAsiento(identifier)));
    }


}

