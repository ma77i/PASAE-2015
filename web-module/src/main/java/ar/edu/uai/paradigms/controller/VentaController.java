package ar.edu.uai.paradigms.controller;


import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dto.VentaDTO;
import ar.edu.uai.paradigms.service.EspectaculoService;
import ar.edu.uai.paradigms.service.EspectadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ar.edu.uai.paradigms.service.VentaService;
import ar.edu.uai.paradigms.translator.VentaTranslator;

import java.util.ArrayList;
import java.util.Collection;


@Controller
@RequestMapping("/venta")
public class VentaController {


	private static final Logger LOGGER = LoggerFactory
			.getLogger(VentaController.class);

	private VentaService ventaService;

	private VentaTranslator ventaTranslator;

	private EspectadorService espectadorService;

	private EspectaculoService espectaculoService;

	public VentaController(VentaService ventaService,
			VentaTranslator ventaTranslator, EspectadorService espectadorService, EspectaculoService espectaculoService) {
		super();
		this.ventaService = ventaService;
		this.ventaTranslator = ventaTranslator;
		this.espectadorService=espectadorService;
		this.espectaculoService=espectaculoService;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	VentaDTO createVenta(@RequestBody VentaDTO ventaDTO) {
		LOGGER.debug("Received DTO: " + ventaDTO);
		Espectador espectador = espectadorService.retrieveUsuario(ventaDTO.getEspectadorId());
		Espectaculo espectaculo = espectaculoService.retrieveEspectaculo(ventaDTO.getEspectaculoId());
		Funcion funcion=espectaculoService.getFuncionDeEspectaculo(ventaDTO.getFuncionId());
        ventaService.agregarVentaParaEspectador(espectador,this.ventaService.saveVenta(this.ventaTranslator.translate(ventaDTO)));

		//espectador.getCompras().add(this.ventaService.saveVenta(this.ventaTranslator.translate(ventaDTO)));

		return this.ventaTranslator
				.translateToDTO(this.ventaService
						.saveVenta(this.ventaTranslator
								.translate(ventaDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public @ResponseBody
	VentaDTO getVenta(@PathVariable long identifier) {
		return this.ventaTranslator
				.translateToDTO(this.ventaService
						.retrieveVenta(identifier));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}/MisCompras")
	public @ResponseBody Collection<VentaDTO> misCompras(@PathVariable long identifier ){
    Collection<VentaDTO> misCompras= new ArrayList<VentaDTO>();

	Collection<Venta> compras=(this.ventaService.listarComprasDeEspectador(identifier));
    for (Venta v: compras){
		 misCompras.add(ventaTranslator.translateToDTO(v));
	}
    return misCompras;
	}



}