package ar.edu.uai.paradigms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uai.model.Empleado;
import ar.edu.uai.paradigms.dto.EmpleadoDTO;
import ar.edu.uai.paradigms.service.EmpleadoService;
import ar.edu.uai.paradigms.translator.EmpleadoTranslator;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController  {

	public EmpleadoController(EmpleadoService empleadoService, EmpleadoTranslator empleadoTranslator) {
		super();
		this.empleadoService = empleadoService;
		this.empleadoTranslator = empleadoTranslator;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(EspectadorController.class);

	private EmpleadoService empleadoService;

	private EmpleadoTranslator empleadoTranslator;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody EmpleadoDTO createEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
		LOGGER.debug("Received DTO: " + empleadoDTO);
		return this.empleadoTranslator.translateToDTO(this.empleadoService.saveUsuario(this.empleadoTranslator.translate(empleadoDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public @ResponseBody EmpleadoDTO getEmpleado(@PathVariable long identifier) {
		return this.empleadoTranslator.translateToDTO(this.empleadoService.retrieveUsuario(identifier));
	}

	@RequestMapping(value = "/{identifier}/cambiardatos", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody EmpleadoDTO cambiarDatosPersonales(@RequestBody EmpleadoDTO empleadoDTO) {
		LOGGER.debug("Received DTO: " + empleadoDTO);
		return this.empleadoTranslator.translateToDTO(this.empleadoService.modificarDatosPersonales(this.empleadoTranslator.translate(empleadoDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listadoEmpleados")
	public @ResponseBody Collection<EmpleadoDTO> listadoEmpleados() {
		Collection<Empleado> lista = this.empleadoService.listarEmpleados();
		Collection<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
		for (Empleado empleado : lista) {
			empleados.add(empleadoTranslator.translateToDTO(empleado));
		}
		return empleados;
	}




}
