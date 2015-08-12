package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Fila;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dto.AsientoDTO;
import ar.edu.uai.paradigms.dto.VentaDTO;
import ar.edu.uai.paradigms.service.EspectaculoService;
import ar.edu.uai.paradigms.service.EspectadorService;
import ar.edu.uai.paradigms.service.TarjetaService;

import java.util.ArrayList;
import java.util.Collection;

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
		Collection<Asiento> asientos = new ArrayList<Asiento>();
		for (AsientoDTO asiento : ventaDTO.getAsientos()) {
			Fila f = new Fila(asiento.getNumero());
			asientos.add(new Asiento(asiento.getNumero(), f));
		}
		return new Venta(ventaDTO.getMonto(), ventaDTO.getCuotas(), ventaDTO.getCvv(), asientos);

	}

	public VentaDTO translateToDTO(Venta venta) {
//		return new VentaDTO(venta.getId(),venta.getMonto(),venta.getCoutas(),venta.getFuncion(),null,venta.getTarjeta().getId(),venta.getTarjeta().getCvv(),null);
		return null;
		
	}
	
	public VentaDTO translateMontoToDTO(Venta venta){
		return new VentaDTO(venta.getMonto(), null, null, null, null, null);
	}
	
	

}
