package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dto.SectorDTO;
import ar.edu.uai.paradigms.service.SectorService;
import ar.edu.uai.paradigms.translator.SectorTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
