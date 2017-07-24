package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.dto.EspectaculoDTO;
import ar.edu.uai.paradigms.dto.FuncionDTO;
import ar.edu.uai.paradigms.service.EspectaculoService;
import ar.edu.uai.paradigms.service.FuncionService;
import ar.edu.uai.paradigms.translator.EspectaculoTranslator;
import ar.edu.uai.paradigms.translator.FuncionTranslator;
import ar.edu.uai.paradigms.validators.EspectaculoDTOValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping("/espectaculo")
public class EspectaculoController {

	public EspectaculoController(EspectaculoService espectaculoService, EspectaculoTranslator espectaculoTranslator, FuncionService funcionService, FuncionTranslator funcionTranslator) {
		super();
		this.espectaculoService = espectaculoService;
		this.espectaculoTranslator = espectaculoTranslator;
		this.funcionService = funcionService;
		this.funcionTranslator = funcionTranslator;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(EspectaculoController.class);

	private EspectaculoService espectaculoService;

	private EspectaculoTranslator espectaculoTranslator;

	private FuncionService funcionService;

	private FuncionTranslator funcionTranslator;


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new EspectaculoDTOValidator());
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createEspectaculo(@RequestPart("imagen") MultipartFile imagen, @RequestPart("imagen_portada") MultipartFile imagen_portada, @RequestParam("datos") String datos) throws IOException {
		EspectaculoDTO espectaculoDTO = new ObjectMapper().readValue(datos, EspectaculoDTO.class);
		LOGGER.debug("Received DTO: " + espectaculoDTO);
		this.espectaculoService.saveEspectaculo(this.espectaculoTranslator.translate(espectaculoDTO), espectaculoDTO.getCategoriaId(), espectaculoDTO.getTeatroId(), imagen, imagen_portada);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public
	@ResponseBody
	EspectaculoDTO getEspectaculo(@PathVariable long identifier) throws FileNotFoundException, SQLException {
		return this.espectaculoTranslator.translateToDTO(this.espectaculoService.retrieveEspectaculo(identifier));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listadoespectaculos")
	public
	@ResponseBody
	Collection<EspectaculoDTO> listadoEspectaculos() throws FileNotFoundException, SQLException, InterruptedException {

		Collection<EspectaculoDTO> espectaculos = new ArrayList<EspectaculoDTO>();
		Collection<Espectaculo> coleccion = this.espectaculoService.listarEspectaculos();
		for (Espectaculo e : coleccion) {
			espectaculos.add(espectaculoTranslator.translateToDTO(e));
		}
		/*try {
			while (true) {

				Thread.sleep(10000);
			}
		}
		catch (InterruptedException ex) {

			Thread.currentThread().interrupt();
		}*/
		return espectaculos;
	}

	@RequestMapping(value = "/{identifier}/modificardatos", method = RequestMethod.POST, consumes = "application/json")
	public
	@ResponseBody
	EspectaculoDTO modificarDatos(@RequestBody EspectaculoDTO espectaculoDTO) throws FileNotFoundException, SQLException {
		LOGGER.debug("Received DTO: " + espectaculoDTO);
		return this.espectaculoTranslator.translateToDTO(this.espectaculoService.modificarEspectaculo(this.espectaculoService.retrieveEspectaculo(espectaculoDTO.getId()), espectaculoDTO.getNombre(), espectaculoDTO.getDescripcion(), espectaculoDTO.getTeatroId()));
	}

	@RequestMapping(value = "/filtrarespectaculospornombre/{nombre_espectaculo}", method = RequestMethod.GET)
	public
	@ResponseBody
	Collection<EspectaculoDTO> getEspectaculosPorNombre(@PathVariable String nombre_espectaculo) throws FileNotFoundException, SQLException {
		Collection<EspectaculoDTO> espectaculos = new ArrayList<EspectaculoDTO>();
		Collection<Espectaculo> coleccion = this.espectaculoService.listarEspectaculosPorNombre(nombre_espectaculo);
		for (Espectaculo e : coleccion) {
			espectaculos.add(espectaculoTranslator.translateToDTO(e));
		}
		return espectaculos;
	}

	@RequestMapping(value = "/{idespectaculo}/listadofunciones ", method = RequestMethod.GET)
	public
	@ResponseBody
	Collection<FuncionDTO> getFuncionesDeEspectaculo(@PathVariable long idespectaculo) {
		Collection<FuncionDTO> funciones = new ArrayList<FuncionDTO>();
		Collection<Funcion> coleccion = this.funcionService.listarFuncionesDeEspectaculo(idespectaculo);
		for (Funcion f : coleccion) {
			funciones.add(funcionTranslator.translateToDTO(f));
		}
		return funciones;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listadoespectaculosentrefechas/{inicio}/{fin}")
	public
	@ResponseBody
	Collection<EspectaculoDTO> getFuncionesEntreFechas(@PathVariable("inicio") @DateTimeFormat(pattern = "dd-MM-yyyy") Date inicio, @PathVariable("fin") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fin) throws FileNotFoundException, SQLException {
		Collection<EspectaculoDTO> espectaculos = new ArrayList<EspectaculoDTO>();
		Collection<Espectaculo> coleccion = this.espectaculoService.listarEspectaculosEntreFechas(inicio, fin);
		for (Espectaculo e : coleccion) {
			espectaculos.add(espectaculoTranslator.translateToDTO(e));
		}
		return espectaculos;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/eliminar/{identifier}")
	@ResponseStatus(value = HttpStatus.OK)
	public void eliminarEspectaculo(@PathVariable long identifier) {
		this.espectaculoService.deleteEspectaculo(identifier);
	}


	@RequestMapping(method = RequestMethod.GET, value = "/listadoespectaculosporcategoria/{nombrecategoria}")
	public
	@ResponseBody
	Collection<EspectaculoDTO> getEspectaculosSegunCategoria(@PathVariable String nombrecategoria) throws FileNotFoundException, SQLException {
		Collection<EspectaculoDTO> espectaculos = new ArrayList<EspectaculoDTO>();
		Collection<Espectaculo> coleccion = this.espectaculoService.listarEspectaculosSegunCategoria(nombrecategoria);
		for (Espectaculo e : coleccion) {
			espectaculos.add(espectaculoTranslator.translateToDTO(e));
		}
		return espectaculos;
	}


	@RequestMapping(method = RequestMethod.GET, value = "/espectaculosdeteatro/{nombreteatro}")
	public
	@ResponseBody
	Long getEspectaculosSegunTeatro(@PathVariable String nombreteatro) {
		return this.espectaculoService.cantidadEspectaculosDeTeatro(nombreteatro);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/funcionesasociadas/{idEspectaculo}")
	public @ResponseBody
	Long cantidadFuncionesSegunEspectaculo(@PathVariable long idEspectaculo) {
		return this.espectaculoService.cantidadFuncionesDeEspectaculo(idEspectaculo);
	}



}