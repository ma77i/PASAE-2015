package ar.edu.uai.paradigms.controller;

import ar.edu.uai.paradigms.dto.FuncionDTO;
import ar.edu.uai.paradigms.service.FuncionService;
import ar.edu.uai.paradigms.translator.FuncionTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Matias on 29/06/2015.
 */
@Controller
@RequestMapping("/funcion")
public class FuncionController {
    private FuncionService funcionService;
    private FuncionTranslator funcionTranslator;
    private static final Logger LOGGER = LoggerFactory.getLogger(FuncionController.class);


    public FuncionController(FuncionService funcionService, FuncionTranslator funcionTranslator) {
        this.funcionService = funcionService;
        this.funcionTranslator = funcionTranslator;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    FuncionDTO createFuncion(@RequestBody FuncionDTO funcionDTO) {

        LOGGER.debug("Received DTO: " + funcionDTO);
        return this.funcionTranslator.translateToDTO(this.funcionService.saveFuncion(this.funcionTranslator.translate(funcionDTO), funcionDTO.getEspectaculoId()));

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    FuncionDTO getFuncion(@PathVariable long identifier) {
        return this.funcionTranslator.translateToDTO(this.funcionService.retrieveFuncion(identifier));
    }

    @RequestMapping(value = "/{identifier}/modificar_datos", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    FuncionDTO modificarFuncion(@RequestBody FuncionDTO funcionDTO) {
        LOGGER.debug("Received DTO: " + funcionDTO);
        return this.funcionTranslator.translateToDTO(this.funcionService.modificarFuncion(this.funcionTranslator.translate(funcionDTO)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/eliminar/{identifier}")
    public
    @ResponseBody
    void eliminarFuncion(@PathVariable long identifier) {
        this.funcionService.deleteFuncion(identifier);
    }


}
