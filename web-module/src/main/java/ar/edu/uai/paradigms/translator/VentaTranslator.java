package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Fila;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dto.AsientoDTO;
import ar.edu.uai.paradigms.dto.EstEspectaculoDTO;
import ar.edu.uai.paradigms.dto.EstadisticaDTO;
import ar.edu.uai.paradigms.dto.VentaDTO;
import ar.edu.uai.paradigms.service.*;

import java.util.ArrayList;
import java.util.Collection;

public class VentaTranslator {

	//private final static String serviceUrl = "http://localhost:8080/api/example";


	private EspectadorService espectadorService;

	private EspectaculoService espectaculoService;

	private TarjetaService tarjetaService;

	private AsientoService asientoService;

	private SectorService sectorService;


	public void setEspectadorService(EspectadorService espectadorService) {
		this.espectadorService = espectadorService;
	}


	public void setEspectaculoService(EspectaculoService espectaculoService) {
		this.espectaculoService = espectaculoService;
	}

	public void setTarjetaService(TarjetaService tarjetaService) {
		this.tarjetaService = tarjetaService;
	}

	public void setAsientoService(AsientoService asientoService) {
		this.asientoService = asientoService;
	}

	public void setSectorService(SectorService sectorService) {
		this.sectorService = sectorService;
	}

	public Venta translate(VentaDTO ventaDTO) {
		Collection<Asiento> asientos = new ArrayList<Asiento>();
		for (AsientoDTO asientoDTO : ventaDTO.getAsientos()) {
			//Fila fila = new Fila((this.filaService.retrieveFila(asientoDTO.getFilaId())).getNro_fila());
			//fila.setSector(this.sectorService.retrieveSector(fila.getSector().getId()));
			//Asiento asiento=this.asientoService.retrieveAsiento(asientoDTO.getId());
			Asiento asiento = new Asiento(asientoDTO.getNumero(), new Fila(), asientoDTO.isOcupado());
			asiento.setId(asientoDTO.getId());
			asiento.getFila().setId(asientoDTO.getFilaId());
			asientos.add(asiento);
		}
		return new Venta(ventaDTO.getMonto(), ventaDTO.getCuotas(), ventaDTO.getCvv(), asientos);

	}

	public VentaDTO translateToDTO(Venta venta) {
		Collection<AsientoDTO> asientosDTO = new ArrayList<AsientoDTO>();
		for (Asiento asiento : venta.getAsientos()) {
			asientosDTO.add(new AsientoDTO(asiento.getId(), asiento.getFila().getId(), asiento.getNumero(), asiento.isOcupado()));
		}
		return new VentaDTO(venta.getId(), venta.getMonto(), venta.getCoutas(), venta.getFuncion().getId(), null, null, asientosDTO);
	}

	public VentaDTO translateMontoToDTO(Venta venta){
		return new VentaDTO(venta.getId(), venta.getMonto(), null, null, null, null, null);
	}

	public EstadisticaDTO translateVentaEstadistica(Integer mes, Long cantidad){
		return new EstadisticaDTO(this.getStringMonth(mes),cantidad);
	}

    public EstEspectaculoDTO translateEspectaculoVendido(String nombreEspectaculo,Long cantidad){
		return new EstEspectaculoDTO(nombreEspectaculo,cantidad);
	}

	public String getStringMonth(Integer mes) {
		String result="";
		switch (mes) {
			case 1: {
				result = "Enero";
				break;
			}
			case 2: {
				result = "Febrero";
				break;
			}
			case 3: {
				result = "Marzo";
				break;
			}
			case 4: {
				result = "Abril";
				break;
			}
			case 5: {
				result = "Mayo";
				break;
			}
			case 6: {
				result = "Junio";
				break;
			}
			case 7: {
				result = "Julio";
				break;
			}
			case 8: {
				result = "Agosto";
				break;
			}
			case 9: {
				result = "Septiembre";
				break;
			}
			case 10: {
				result = "Octubre";
				break;
			}
			case 11: {
				result = "Noviembre";
				break;
			}
			case 12: {
				result = "Diciembre";
				break;
			}



		}
		return result;
	}


}
