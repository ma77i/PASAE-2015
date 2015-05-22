package ar.edu.uai.paradigms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.uai.model.Administrador;
import ar.edu.uai.paradigms.service.AdministradorService;
import ar.edu.uai.paradigms.service.EspectadorService;
import ar.edu.uai.paradigms.translator.AdministradorTranslator;
import ar.edu.uai.paradigms.translator.EspectadorTranslator;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	public AdministradorController(
			AdministradorService administradorService,
			AdministradorTranslator administradorTranslator) {
		super();
		this.administradorService = administradorService;
		this.administradorTranslator = administradorTranslator;
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdministradorController.class);

	private AdministradorService administradorService;

	private AdministradorTranslator administradorTranslator;
	
}	