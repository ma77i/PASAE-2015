package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Empleado;
import ar.edu.uai.paradigms.dto.EmpleadoDTO;
import ar.edu.uai.paradigms.service.EmpleadoService;
import ar.edu.uai.paradigms.translator.EmpleadoTranslator;
import ar.edu.uai.paradigms.validators.UsuarioDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UsuarioDTOValidator());
	}



	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody EmpleadoDTO createEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
		LOGGER.debug("Received DTO: " + empleadoDTO);
		return this.empleadoTranslator.translateToDTO(this.empleadoService.saveUsuario(this.empleadoTranslator.translate(empleadoDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public @ResponseBody EmpleadoDTO getEmpleado(@PathVariable long identifier) {
		return this.empleadoTranslator.translateToDTO(this.empleadoService.retrieveUsuario(identifier));
	}

	@RequestMapping(value = "/cambiardatospersonales/{identifier}", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody EmpleadoDTO cambiarDatosPersonales(@RequestBody EmpleadoDTO empleadoDTO) {
		LOGGER.debug("Received DTO: " + empleadoDTO);
		return this.empleadoTranslator.translateToDTO(this.empleadoService.modificarDatosPersonales(this.empleadoService.retrieveUsuario(empleadoDTO.getId()), empleadoDTO.getNombre(), empleadoDTO.getApellido(), empleadoDTO.getPassword()));
	}
	@RequestMapping(method = RequestMethod.GET, value = "/listadoempleados")
	public @ResponseBody Collection<EmpleadoDTO> listadoEmpleados() {
		Collection<Empleado> lista = this.empleadoService.listarEmpleados();
		Collection<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
		for (Empleado empleado : lista) {
			empleados.add(empleadoTranslator.translateToDTO(empleado));
		}
		return empleados;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/busquedaempleados/{input}")
	public
	@ResponseBody
	Collection<EmpleadoDTO> busquedaEmpleados(@PathVariable String input) {
		Collection<Empleado> lista = this.empleadoService.listarEmpleadosPorCampoIngresado(input);
		Collection<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
		for (Empleado empleado : lista) {
			empleados.add(empleadoTranslator.translateToDTO(empleado));
		}
		return empleados;

	}

	@RequestMapping(value = "/cambiarestado/{identifier}", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	EmpleadoDTO cambiarEstado (@RequestBody EmpleadoDTO empleadoDTO) {

		LOGGER.debug("Received DTO: " + empleadoDTO);
		return this.empleadoTranslator.translateToDTO(this.empleadoService.modificarEstado(this.empleadoService.retrieveUsuario(empleadoDTO.getId()),empleadoDTO.getEstado()));


	}




}
