package ar.edu.uai.paradigms.controller;

import ar.edu.uai.paradigms.dto.FuncionDTO;
import ar.edu.uai.paradigms.service.FuncionService;
import ar.edu.uai.paradigms.translator.FuncionTranslator;
import ar.edu.uai.paradigms.validators.FuncionDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new FuncionDTOValidator());
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    FuncionDTO createFuncion(@RequestBody @Valid FuncionDTO funcionDTO) {

        LOGGER.debug("Received DTO: " + funcionDTO);
        return this.funcionTranslator.translateToDTO(this.funcionService.saveFuncion(this.funcionTranslator.translate(funcionDTO)));

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    FuncionDTO getFuncion(@PathVariable long identifier) {
        return this.funcionTranslator.translateToDTO(this.funcionService.retrieveFuncion(identifier));
    }

    @RequestMapping(value = "/{identifier}/modificardatos", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    FuncionDTO modificarFuncion(@RequestBody FuncionDTO funcionDTO) {
        LOGGER.debug("Received DTO: " + funcionDTO);
        return this.funcionTranslator.translateToDTO(this.funcionService.modificarFuncion(this.funcionTranslator.translate(funcionDTO)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/eliminar/{identifier}")
    @ResponseStatus(value = HttpStatus.OK)
    public void eliminarFuncion(@PathVariable long identifier) {
        this.funcionService.deleteFuncion(identifier);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ventasdefuncion/{idfuncion}")
    public @ResponseBody
    Long getVentasSegunFuncion(@PathVariable long idfuncion) {
        return this.funcionService.cantidadVentasDeFuncion(idfuncion);
    }


}
