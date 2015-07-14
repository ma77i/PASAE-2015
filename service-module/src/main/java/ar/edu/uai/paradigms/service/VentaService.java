package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Venta;

import java.util.Collection;

public interface VentaService {
	public Venta saveVenta(Venta venta);
	public Venta retrieveVenta(long identifier);
	public Collection<Venta> listarVentas();
	public Collection<Venta> listarComprasDeEspectador(long id_espectador);
	public Float calcularMontoFinal(long id_sector, long id_espectaculo);
	public Float calcularMontoNeto(long id_sector, long id_espectaculo);
	public Float aplicarDescuento(long id_espectaculo);

	public void agregarVentaParaEspectador(Venta venta);
	
}
