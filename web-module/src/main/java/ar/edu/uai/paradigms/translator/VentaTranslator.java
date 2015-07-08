package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dto.VentaDTO;
import ar.edu.uai.paradigms.service.EspectaculoService;
import ar.edu.uai.paradigms.service.EspectadorService;
import ar.edu.uai.paradigms.service.TarjetaService;

public class VentaTranslator {

	//private final static String serviceUrl = "http://localhost:8080/api/example";


	private EspectadorService espectadorService;



	private EspectaculoService espectaculoService;

	private TarjetaService tarjetaService;



	public void setEspectadorService(EspectadorService espectadorService) {
		this.espectadorService = espectadorService;
	}


	public void setEspectaculoService(EspectaculoService espectaculoService) {
		this.espectaculoService = espectaculoService;
	}

	public void setTarjetaService(TarjetaService tarjetaService) {
		this.tarjetaService = tarjetaService;
	}


	public Venta translate(VentaDTO ventaDTO) {
		Espectador espectador = espectadorService.retrieveUsuario(ventaDTO.getEspectadorId());
		// Espectaculo espectaculo =
		// espectaculoService.retrieveEspectaculo(ventaDTO.getEspectaculoId());

		Funcion funcion = espectaculoService.getFuncionDeEspectaculo(ventaDTO.getFuncionId());



     //habria que validar que esa compra se pueda realizar mediante wiremock , ya que esto simularia la validacion de la tarjeta

		Tarjeta tarjeta=tarjetaService.retrieveTarjeta(ventaDTO.getTarjetaId());

		//tarjetaService.verificandoDatosTarjeta();

		/*RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

		//Add the Jackson Message converter
		messageConverters.add(new MappingJackson2HttpMessageConverter());

		//Add the message converters to the restTemplate
		restTemplate.setMessageConverters(messageConverters);



		*/

		return new Venta(ventaDTO.getMonto(), ventaDTO.getCostoAdicional(), ventaDTO.getFechaVenta(), ventaDTO.getCuotas(), funcion, espectador);
	}

	public VentaDTO translateToDTO(Venta venta) {
		return new VentaDTO(venta.getMonto(), venta.getCostoAdicional(), venta.getFechaVenta(), venta.getCoutas(), venta.getFuncion().getEspectaculo().getId(), venta.getFuncion()
				.getId(), venta.getComprador().getId(),venta.getTarjeta().getId());
	}

}
