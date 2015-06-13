package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dto.AsientoDTO;
import ar.edu.uai.paradigms.dto.SectorDTO;
import ar.edu.uai.paradigms.service.SectorService;
import ar.edu.uai.paradigms.translator.AsientoTranslator;
import ar.edu.uai.paradigms.translator.SectorTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by EzequielPanoff on 9/6/15.
 */

@Controller
@RequestMapping("/sector")
public class SectorController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SectorController.class);

    private SectorService sectorService;

    private SectorTranslator sectorTranslator;

    private AsientoTranslator asientoTranslator;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    SectorDTO createSector (@RequestBody SectorDTO sectorDTO) {
        LOGGER.debug("Received DTO: " + sectorDTO);
        return this.sectorTranslator
                .translateToDTO((Sector) this.sectorService
                        .saveSector(this.sectorTranslator
                                .translate(sectorDTO)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public @ResponseBody
    SectorDTO getSector (@PathVariable long identifier) {
        return this.sectorTranslator
                .translateToDTO((Sector) this.sectorService
                        .retrieveSector(identifier));
    }


    @RequestMapping (method = RequestMethod.GET, value = "/{identifier}/asientos")
    public @ResponseBody
    Collection<AsientoDTO> getAsientos (@PathVariable long identifier) {
        Collection<AsientoDTO> asientos= new ArrayList<AsientoDTO>();
        for (Iterator iterator = this.sectorService.asientosDeSector(identifier).iterator(); iterator.hasNext();) {
            Asiento asiento = (Asiento) iterator.next();
            asientos.add(this.asientoTranslator.translateToDTO(asiento));

        }
        return  asientos;

    }

    @RequestMapping (method = RequestMethod.GET, value = "/{identifier}/asientos_disponibles")
       public @ResponseBody
       Collection<AsientoDTO> getAsientosDisponibles (@PathVariable long identifier) {
        Collection<AsientoDTO> asientos_disponibles= new ArrayList<AsientoDTO>();
        for (Iterator iterator = this.sectorService.asientosDisponiblesDeSector(identifier).iterator(); iterator.hasNext();) {
            Asiento asiento = (Asiento) iterator.next();
            asientos_disponibles.add(this.asientoTranslator.translateToDTO(asiento));

        }
        return  asientos_disponibles;

    }


    @RequestMapping (method = RequestMethod.GET, value = "/{identifier}/asientos_ocupados")
    public @ResponseBody
    Collection<AsientoDTO> getAsientosOcupados (@PathVariable long identifier) {
        Collection<AsientoDTO> asientos_ocupados= new ArrayList<AsientoDTO>();
        for (Iterator iterator = this.sectorService.asientosOcupadosDeSector(identifier).iterator(); iterator.hasNext();) {
            Asiento asiento = (Asiento) iterator.next();
            asientos_ocupados.add(this.asientoTranslator.translateToDTO(asiento));

        }
        return  asientos_ocupados;

    }




}
