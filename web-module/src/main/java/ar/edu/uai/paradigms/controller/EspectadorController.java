package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.paradigms.dto.EspectadorDTO;
import ar.edu.uai.paradigms.service.EspectadorService;
import ar.edu.uai.paradigms.service.TarjetaService;
import ar.edu.uai.paradigms.translator.EspectadorTranslator;
import ar.edu.uai.paradigms.translator.TransaccionTranslator;
import ar.edu.uai.paradigms.validators.UsuarioDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */

@Controller
@RequestMapping("/espectador")
public class EspectadorController {

	public EspectadorController(EspectadorService espectadorService, EspectadorTranslator espectadorTranslator,TarjetaService tarjetaService,TransaccionTranslator transaccionTranslator) {
		super();
		this.espectadorService = espectadorService;
		this.espectadorTranslator = espectadorTranslator;
		this.tarjetaService=tarjetaService;
		this.transaccionTranslator=transaccionTranslator;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(EspectadorController.class);

	private EspectadorService espectadorService;

	private EspectadorTranslator espectadorTranslator;

	private TarjetaService tarjetaService;

	private TransaccionTranslator transaccionTranslator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UsuarioDTOValidator());
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody EspectadorDTO createEspectador(@RequestBody @Valid EspectadorDTO espectadorDTO) {

			LOGGER.debug("Received DTO: " + espectadorDTO);
			//Usuario espectador = espectadorService.existeUsuario(espectadorDTO.getEmail());
			return this.espectadorTranslator.translateToDTO(this.espectadorService.saveUsuario(this.espectadorTranslator.translate(espectadorDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public @ResponseBody EspectadorDTO getEspectador(@PathVariable long identifier) {
		return this.espectadorTranslator.translateToDTO(this.espectadorService.retrieveUsuario(identifier));
	}

	@RequestMapping(value = "/cambiardatospersonales/{identifier}", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody EspectadorDTO cambiarDatosPersonales(@RequestBody EspectadorDTO espectadorDTO) {
		LOGGER.debug("Received DTO: " + espectadorDTO);
		return this.espectadorTranslator.translateToDTO(this.espectadorService.modificarDatosPersonales(this.espectadorService.retrieveUsuario(espectadorDTO.getId()), espectadorDTO.getNombre(), espectadorDTO.getApellido(), espectadorDTO.getPassword()));
	}

	@RequestMapping(value = "/cambiarestado/{identifier}", method = RequestMethod.POST, consumes = "application/json")
	public
	@ResponseBody
	EspectadorDTO cambiarEstado(@RequestBody EspectadorDTO espectadorDTO) {
		LOGGER.debug("Received DTO: " + espectadorDTO);
		return this.espectadorTranslator.translateToDTO(this.espectadorService.modificarEstado(this.espectadorService.retrieveUsuario(espectadorDTO.getId()), espectadorDTO.getEstado()));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listadoespectadores")
	public @ResponseBody Collection<EspectadorDTO> listadoEspectadores() {
		Collection<Espectador> lista = this.espectadorService.listarEspectadores();
		Collection<EspectadorDTO> espectadores = new ArrayList<EspectadorDTO>();
		for (Espectador espectador : lista) {
			espectadores.add(espectadorTranslator.translateToDTO(espectador));
		}
		return espectadores;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/busquedaespectadores/{input}")
	public
	@ResponseBody
	Collection<EspectadorDTO> busquedaEspectadores(@PathVariable String input) {
		Collection<Espectador> lista = this.espectadorService.listarEspectadoresPorCampoIngresado(input);
		Collection<EspectadorDTO> espectadores = new ArrayList<EspectadorDTO>();
		for (Espectador espectador : lista) {
			espectadores.add(espectadorTranslator.translateToDTO(espectador));
		}
		return espectadores;

	}

}
