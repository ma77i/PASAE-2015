package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Empleado;
import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.paradigms.dto.EmpleadoDTO;
import ar.edu.uai.paradigms.dto.EspectaculoDTO;
import ar.edu.uai.paradigms.dto.EspectadorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ar.edu.uai.paradigms.service.EspectaculoService;
import ar.edu.uai.paradigms.translator.EspectaculoTranslator;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/espectaculo")
public class EspectaculoController {

	public EspectaculoController(EspectaculoService espectaculoService, EspectaculoTranslator espectaculoTranslator) {
		super();
		this.espectaculoService = espectaculoService;
		this.espectaculoTranslator = espectaculoTranslator;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(EspectaculoController.class);

	private EspectaculoService espectaculoService;

	private EspectaculoTranslator espectaculoTranslator;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody EspectaculoDTO createEspectaculo(@RequestBody EspectaculoDTO espectaculoDTO) {
		LOGGER.debug("Received DTO: " + espectaculoDTO);
		String espectaculo= espectaculoService.existeEspectaculo(espectaculoDTO.getNombre());
		//si espectaculo da blanco entonces recien puedo crear el espectaculo ya que me aseguro que no hay otro igual
		return this.espectaculoTranslator.translateToDTO(this.espectaculoService.saveEspectaculo(this.espectaculoTranslator.translate(espectaculoDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public @ResponseBody EspectaculoDTO getEspectaculo(@PathVariable long identifier) {
		return this.espectaculoTranslator.translateToDTO(this.espectaculoService.retrieveEspectaculo(identifier));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listadoEspectaculos")
	public @ResponseBody Collection<EspectaculoDTO> listadoEspectaculos() {

		Collection<EspectaculoDTO> espectaculos = new ArrayList<EspectaculoDTO>();
		Collection<Espectaculo> coleccion = this.espectaculoService.listarEspectaculos();
		for (Espectaculo e : coleccion) {
			espectaculos.add(espectaculoTranslator.translateToDTO(e));
		}
		return espectaculos;
	}

	@RequestMapping(value = "/{identifier}/cambiardatos", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody EspectaculoDTO modificarDatos(@RequestBody EspectaculoDTO espectaculoDTO) {
		LOGGER.debug("Received DTO: " + espectaculoDTO);
		return this.espectaculoTranslator.translateToDTO(this.espectaculoService.modificarEspectaculo(this.espectaculoTranslator.translate(espectaculoDTO)));
	}

	@RequestMapping(value = "/{nombre_espectaculo}/", method = RequestMethod.POST)
	public @ResponseBody Collection<EspectaculoDTO> getEspectaculosPorNombre(@PathVariable String nombre_espectaculo) {
		Collection<EspectaculoDTO> espectaculos = new ArrayList<EspectaculoDTO>();
		Collection<Espectaculo> coleccion = this.espectaculoService.listarEspectaculosPorNombre(nombre_espectaculo);
		for (Espectaculo e : coleccion) {
			espectaculos.add(espectaculoTranslator.translateToDTO(e));
		}
		return espectaculos;
	}




}
