package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dto.EspectadorDTO;
import ar.edu.uai.paradigms.service.EspectadorService;
import ar.edu.uai.paradigms.translator.EspectadorTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ar.edu.uai.paradigms.validation.Validator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */

@Controller
@RequestMapping("/espectador")
public class EspectadorController {

	public EspectadorController(EspectadorService espectadorService,
								EspectadorTranslator espectadorTranslator) {
		super();
		this.espectadorService = espectadorService;
		this.espectadorTranslator = espectadorTranslator;
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EspectadorController.class);

	private EspectadorService espectadorService;

	private EspectadorTranslator espectadorTranslator;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	EspectadorDTO createEspectador(@RequestBody EspectadorDTO espectadorDTO) {

		LOGGER.debug("Received DTO: " + espectadorDTO);
		Usuario espectador=espectadorService.existeUsuario(espectadorDTO.getUsuario());
		return this.espectadorTranslator
				.translateToDTO(this.espectadorService
						.saveUsuario(this.espectadorTranslator
								.translate(espectadorDTO)));

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public
	@ResponseBody
	EspectadorDTO getEspectador(@PathVariable long identifier) {
		return Validator.validateObject(this.espectadorTranslator
				.translateToDTO(this.espectadorService
						.retrieveUsuario(identifier)));
	}

	@RequestMapping(value = "/{identifier}/cambiardatos", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody  EspectadorDTO cambiarDatosPersonales(@RequestBody EspectadorDTO espectadorDTO) {
		LOGGER.debug("Received DTO: " + espectadorDTO);
		return this.espectadorTranslator.translateToDTO(this.espectadorService.modificarDatosPersonales(this.espectadorTranslator.translate(espectadorDTO)));
	}

	@RequestMapping(value = "/{identifier}/cambiarpass", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody  EspectadorDTO cambiarContrasena(@RequestBody EspectadorDTO espectadorDTO) {
		LOGGER.debug("Received DTO: " + espectadorDTO);
		return this.espectadorTranslator.translateToDTO(this.espectadorService.modificarContrasena(this.espectadorTranslator.translate(espectadorDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listadoEspectadores")
	public @ResponseBody Collection<EspectadorDTO> listadoEspectadores() {
		Collection<Espectador>lista=this.espectadorService.listarEspectadores();
		Collection<EspectadorDTO> espectadores= new ArrayList<EspectadorDTO>();
		for(Espectador espectador: lista ){
			espectadores.add(espectadorTranslator.translateToDTO(espectador));
		}
		return  espectadores;


	}












}




