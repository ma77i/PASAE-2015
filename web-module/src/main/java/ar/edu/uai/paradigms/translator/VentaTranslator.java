package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dto.VentaDTO;
import ar.edu.uai.paradigms.service.EspectaculoService;
import ar.edu.uai.paradigms.service.EspectadorService;

public class VentaTranslator {

	public void setEspectadorService(EspectadorService espectadorService) {
		this.espectadorService = espectadorService;
	}

	public void setEspectaculoService(EspectaculoService espectaculoService) {
		this.espectaculoService = espectaculoService;
	}

	private EspectadorService espectadorService;

	private EspectaculoService espectaculoService;

	public Venta translate(VentaDTO ventaDTO) {
		Espectador espectador = espectadorService.retrieveUsuario(ventaDTO.getEspectadorId());
		// Espectaculo espectaculo =
		// espectaculoService.retrieveEspectaculo(ventaDTO.getEspectaculoId());
		Funcion funcion = espectaculoService.getFuncionDeEspectaculo(ventaDTO.getFuncionId());

		return new Venta(ventaDTO.getMonto(), ventaDTO.getCostoAdicional(), ventaDTO.getFechaVenta(), ventaDTO.getCuotas(), funcion, espectador);
	}

	public VentaDTO translateToDTO(Venta venta) {
		return new VentaDTO(venta.getMonto(), venta.getCostoAdicional(), venta.getFechaVenta(), venta.getCoutas(), venta.getFuncion().getEspectaculo().getId(), venta.getFuncion()
				.getId(), venta.getComprador().getId());
	}

}
