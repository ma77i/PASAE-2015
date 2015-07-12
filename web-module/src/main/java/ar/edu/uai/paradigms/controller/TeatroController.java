package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Teatro;
import ar.edu.uai.paradigms.dto.TeatroDTO;
import ar.edu.uai.paradigms.service.TeatroService;
import ar.edu.uai.paradigms.translator.TeatroTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Matias on 08/07/2015.
 */

@Controller
@RequestMapping("/teatro")
public class TeatroController {


    private static final Logger LOGGER = LoggerFactory.getLogger(TeatroController.class);

    private TeatroService teatroService;

    private TeatroTranslator teatroTranslator;


    public TeatroController(TeatroService teatroService, TeatroTranslator teatroTranslator) {
        this.teatroService = teatroService;
        this.teatroTranslator = teatroTranslator;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    TeatroDTO createTeatro(@RequestBody TeatroDTO teatroDTO) {
        LOGGER.debug("Received DTO: " + teatroDTO);
        return this.teatroTranslator.translateToDTO(this.teatroService.saveTeatro(this.teatroTranslator.translate(teatroDTO)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    TeatroDTO getTeatro(@PathVariable long identifier) {
        return this.teatroTranslator.translateToDTO(this.teatroService.retrieveTeatro(identifier));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listadoTeatros")
    public
    @ResponseBody
    Collection<TeatroDTO> listadoTeatros() {

        Collection<TeatroDTO> teatros = new ArrayList<TeatroDTO>();
        Collection<Teatro> coleccion = this.teatroService.listarTeatros();
        for (Teatro e : coleccion) {
            teatros.add(teatroTranslator.translateToDTO(e));
        }
        return teatros;
    }


}
