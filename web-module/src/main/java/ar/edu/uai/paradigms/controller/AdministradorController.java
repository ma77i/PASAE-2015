package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Administrador;
import ar.edu.uai.paradigms.dto.AdministradorDTO;
import ar.edu.uai.paradigms.service.AdministradorService;
import ar.edu.uai.paradigms.translator.AdministradorTranslator;
import ar.edu.uai.paradigms.validators.UsuarioDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	public AdministradorController(AdministradorService administradorService, AdministradorTranslator administradorTranslator) {
		super();
		this.administradorService = administradorService;
		this.administradorTranslator = administradorTranslator;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(AdministradorController.class);

	private AdministradorService administradorService;

	private AdministradorTranslator administradorTranslator;


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UsuarioDTOValidator());
	}



	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody AdministradorDTO createAdministrador(@RequestBody AdministradorDTO administradorDTO) {
		LOGGER.debug("Received DTO: " + administradorDTO);
		return this.administradorTranslator.translateToDTO((Administrador) this.administradorService.saveUsuario(this.administradorTranslator.translate(administradorDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public @ResponseBody AdministradorDTO getAdministrador(@PathVariable long identifier) {
		return this.administradorTranslator.translateToDTO((Administrador) this.administradorService.retrieveUsuario(identifier));
	}

	@RequestMapping(value = "/cambiardatospersonales/{identifier}", method = RequestMethod.POST, consumes = "application/json")
	public
	@ResponseBody
	AdministradorDTO cambiarDatosPersonales(@RequestBody AdministradorDTO administradorDTO) {
		LOGGER.debug("Received DTO: " + administradorDTO);
		return this.administradorTranslator.translateToDTO(this.administradorService.modificarDatosPersonales(this.administradorService.retrieveUsuario(administradorDTO.getId()), administradorDTO.getNombre(), administradorDTO.getApellido(), administradorDTO.getPassword()));
	}

}