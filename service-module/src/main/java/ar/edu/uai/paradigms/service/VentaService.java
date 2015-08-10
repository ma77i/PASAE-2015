package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.model.Venta;

import java.util.Collection;

public interface VentaService {
	public Venta saveVenta(Venta venta, Long espectaculoId, Long funcionId, Long espectadorId, Long tarjetaId);
	public Venta retrieveVenta(long identifier);
	public Collection<Venta> listarVentas();
	public Collection<Venta> listarComprasDeEspectador(long id_espectador);

	public Float calcularMontoFinal(Long id_sector, Integer cantidad_asientos);
	public Float calcularMontoNeto(long id_sector, long id_espectaculo);
	public Float aplicarDescuento(long id_espectaculo);

	public void agregarVentaParaEspectador(Venta venta);

	void agregarFuncionParaVenta(Venta venta, Funcion funcion);

	void agregarEspectadorParaVenta(Venta venta, Espectador espectador);

	void agregarTarjetaParaVenta(Venta venta, Tarjeta tarjeta);
}
