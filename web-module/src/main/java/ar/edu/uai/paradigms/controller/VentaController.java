package ar.edu.uai.paradigms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.uai.paradigms.service.VentaService;
import ar.edu.uai.paradigms.translator.VentaTranslator;


@Controller
@RequestMapping("/venta")
public class VentaController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(VentaController.class);

	private VentaService ventaService;

	private VentaTranslator ventaTranslator;

	public VentaController(VentaService ventaService,
			VentaTranslator ventaTranslator) {
		super();
		this.ventaService = ventaService;
		this.ventaTranslator = ventaTranslator;
	}

	
	
}
