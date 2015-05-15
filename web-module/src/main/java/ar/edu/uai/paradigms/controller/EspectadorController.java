package ar.edu.uai.paradigms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.paradigms.dto.EspectadorDTO;
import ar.edu.uai.paradigms.service.UsuarioService;
import ar.edu.uai.paradigms.translator.EspectadorTranslator;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */

@Controller
@RequestMapping("/espectador")
public class EspectadorController {

	public EspectadorController(
			UsuarioService usuarioService,
			EspectadorTranslator espectadorTranslator) {
		super();
		this.usuarioService = usuarioService;
		this.espectadorTranslator = espectadorTranslator;
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EspectadorController.class);

	private UsuarioService usuarioService;

	private EspectadorTranslator espectadorTranslator;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody EspectadorDTO createEspectador(@RequestBody EspectadorDTO espectadorDTO) {
		LOGGER.debug("Received DTO: " + espectadorDTO);
		return this.espectadorTranslator.translateToDTO((Espectador) this.usuarioService
                .saveUsuario(this.espectadorTranslator.translate(espectadorDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public @ResponseBody EspectadorDTO getEspectador(@PathVariable long identifier) {
		return this.espectadorTranslator.translateToDTO((Espectador) this.usuarioService.retrieveUsuario(identifier));
	}
}