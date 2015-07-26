package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.paradigms.dto.TarjetaDTO;
import ar.edu.uai.paradigms.service.TarjetaService;
import ar.edu.uai.paradigms.translator.TarjetaTranslator;
import ar.edu.uai.paradigms.validators.TarjetaDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Matias on 26/06/2015.
 */
@Controller
@RequestMapping("/tarjeta")
public class TarjetaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaController.class);

    private TarjetaTranslator tarjetaTranslator;

    private TarjetaService tarjetaService;

    public TarjetaController(TarjetaTranslator tarjetaTranslator, TarjetaService tarjetaService) {
        this.tarjetaTranslator = tarjetaTranslator;
        this.tarjetaService = tarjetaService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new TarjetaDTOValidator());
    }


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    TarjetaDTO create(@RequestBody @Valid TarjetaDTO tarjetaDTO) {

        LOGGER.debug("Received DTO: " + tarjetaDTO);
        return tarjetaTranslator.translateToDTO(this.tarjetaService.saveTarjeta(this.tarjetaTranslator.translate(tarjetaDTO)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    TarjetaDTO getTarjeta(@PathVariable long identifier) {
        return this.tarjetaTranslator.translateToDTO(this.tarjetaService.retrieveTarjeta(identifier));
    }


    @RequestMapping(method = RequestMethod.POST, value = "/eliminar/{identifier}")
    @ResponseStatus(value = HttpStatus.OK)
    public
    void eliminarTarjeta(@PathVariable long identifier) {
        this.tarjetaService.deleteTarjeta(identifier);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/listadotarjetas")
    public
    @ResponseBody
    Collection<TarjetaDTO> listadoTarjetas() {
        Collection<Tarjeta> lista = this.tarjetaService.listarTarjetas();
        Collection<TarjetaDTO> tarjetas = new ArrayList<TarjetaDTO>();
        for (Tarjeta tarjeta : lista) {
            tarjetas.add(tarjetaTranslator.translateToDTO(tarjeta));
        }
        return tarjetas;
    }


}
