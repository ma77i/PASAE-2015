package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dto.AsientoDTO;
import ar.edu.uai.paradigms.dto.SectorDTO;
import ar.edu.uai.paradigms.dto.SectoresDTO;
import ar.edu.uai.paradigms.service.SectorService;
import ar.edu.uai.paradigms.translator.AsientoTranslator;
import ar.edu.uai.paradigms.translator.SectorTranslator;
import ar.edu.uai.paradigms.translator.SectoresTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(SectorController.class);

	private SectorService sectorService;

	private SectorTranslator sectorTranslator;

	private AsientoTranslator asientoTranslator;

	private SectoresTranslator sectoresTranslator;

	public SectorController(SectorService sectorService, SectorTranslator sectorTranslator, AsientoTranslator asientoTranslator,SectoresTranslator sectoresTranslator) {
		this.sectorService = sectorService;
		this.sectorTranslator = sectorTranslator;
		this.asientoTranslator = asientoTranslator;
		this.sectoresTranslator=sectoresTranslator;
	}


//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.setValidator(new SectorDTOValidator());
//	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public
	@ResponseBody
	SectorDTO createSector(@RequestBody SectorDTO sectorDTO) {
		LOGGER.debug("Received DTO: " + sectorDTO);
		return this.sectorTranslator.translateToDTO(this.sectorService.saveSector(this.sectorTranslator.translate(sectorDTO), sectorDTO.getFuncionId()));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public @ResponseBody SectorDTO getSector(@PathVariable long identifier) {
		return this.sectorTranslator.translateToDTO((this.sectorService.retrieveSector(identifier)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}/asientos")
	public @ResponseBody Collection<AsientoDTO> getAsientos(@PathVariable long identifier) {
		Collection<AsientoDTO> asientos = new ArrayList<AsientoDTO>();
		for (Iterator iterator = this.sectorService.asientosDeSector(identifier).iterator(); iterator.hasNext();) {
			Asiento asiento = (Asiento) iterator.next();
			asientos.add(this.asientoTranslator.translateToDTO(asiento));

		}
		return asientos;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}/cantidadasientos/{cantidad_asientos}")
	public  @ResponseBody Boolean verificarDisponibildad (@PathVariable Long identifier, @PathVariable Integer cantidad_asientos) {
		return this.sectorService.hayDisponibilidad(identifier,cantidad_asientos);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}/asientosdisponibles")
	public @ResponseBody Collection<AsientoDTO> getAsientosDisponibles(@PathVariable long identifier) {
		Collection<AsientoDTO> asientos_disponibles = new ArrayList<AsientoDTO>();
		for (Iterator iterator = this.sectorService.asientosDisponiblesDeSector(identifier).iterator(); iterator.hasNext();) {
			Asiento asiento = (Asiento) iterator.next();
			asientos_disponibles.add(this.asientoTranslator.translateToDTO(asiento));

		}
		return asientos_disponibles;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}/asientosocupados")
	public @ResponseBody Collection<AsientoDTO> getAsientosOcupados(@PathVariable long identifier) {
		Collection<AsientoDTO> asientos_ocupados = new ArrayList<AsientoDTO>();
		for (Iterator iterator = this.sectorService.asientosOcupadosDeSector(identifier).iterator(); iterator.hasNext();) {
			Asiento asiento = (Asiento) iterator.next();
			asientos_ocupados.add(this.asientoTranslator.translateToDTO(asiento));

		}
		return asientos_ocupados;

	}


	@Deprecated
	@RequestMapping(method = RequestMethod.POST, value = "/agregarsectoresparaespectaculo")
	@ResponseStatus(value = HttpStatus.OK)
	public void agregarSectoresParaEspectaculo(@RequestBody SectoresDTO sectoresDTO) {
//		this.sectorService.saveSectoresParaEspectaculo(this.sectoresTranslator.translate(sectoresDTO), sectoresDTO.getIdEspectaculo());

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/agregarsectoresparafuncion")
	@ResponseStatus(value = HttpStatus.OK)
	public void agregarSectoresParaFuncion(@RequestBody SectoresDTO sectoresDTO) {
		this.sectorService.saveSectoresParaFuncion(this.sectoresTranslator.translate(sectoresDTO), sectoresDTO.getIdFuncion());

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getsectores/{idfuncion}")
	public
	@ResponseBody
	Collection<SectorDTO> getSectores(@PathVariable Long idfuncion) {

		Collection<SectorDTO> sectores = new ArrayList<SectorDTO>();
		Collection<Sector> coleccion = this.sectorService.listarSectoresDeFuncion(idfuncion);
		for (Sector sector : coleccion) {
			sectores.add(sectorTranslator.translateToDTO(sector));
		}
		return sectores;
	}



}
