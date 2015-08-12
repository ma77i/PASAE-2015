package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dto.AsientoDTO;
import ar.edu.uai.paradigms.dto.VentaDTO;
import ar.edu.uai.paradigms.service.EspectaculoService;
import ar.edu.uai.paradigms.service.EspectadorService;
import ar.edu.uai.paradigms.service.TarjetaService;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

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
		Collection<Asiento> colleccion = new ArrayList<Asiento>();
		Collection<AsientoDTO> asientos = new ArrayList<AsientoDTO>();
		for (AsientoDTO e : ventaDTO.getAsientos()) {
			//asientos.add(new Asiento(e.getNumero()));
		}
		return null;
		//	return new Venta(ventaDTO.getMonto(),ventaDTO.getCostoAdicional(),ventaDTO.getFechaVenta(),ventaDTO.getCuotas(),ventaDTO.getCvv(),asientos);

		//habria que validar que esa compra se pueda realizar mediante wiremock , ya que esto simularia la validacion de la tarjeta

		//Tarjeta tarjeta=tarjetaService.retrieveTarjeta(ventaDTO.getTarjetaId());

		//tarjetaService.verificandoDatosTarjeta();

		/*RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

		//Add the Jackson Message converter
		messageConverters.add(new MappingJackson2HttpMessageConverter());

		//Add the message converters to the restTemplate
		restTemplate.setMessageConverters(messageConverters);



		*/

	}

	public VentaDTO translateToDTO(Venta venta) {
//		return new VentaDTO(venta.getId(),venta.getMonto(),venta.getCoutas(),venta.getFuncion(),null,venta.getTarjeta().getId(),venta.getTarjeta().getCvv(),null);
		return null;
		
	}
	
	public VentaDTO translateMontoToDTO(Venta venta){
		return new VentaDTO(venta.getMonto(), null, null, null, null, null);
	}
	
	

}
