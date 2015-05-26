package ar.edu.uai.paradigms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.uai.paradigms.service.EspectaculoService;
import ar.edu.uai.paradigms.translator.EspectaculoTranslator;

@Controller
@RequestMapping("/espectaculo")
public class EspectaculoController {
	
	public EspectaculoController(EspectaculoService espectaculoService,
			EspectaculoTranslator espectaculoTranslator) {
		super();
		this.espectaculoService = espectaculoService;
		this.espectaculoTranslator = espectaculoTranslator;
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EspectaculoController.class);

	private EspectaculoService espectaculoService;

	private EspectaculoTranslator espectaculoTranslator;

}
