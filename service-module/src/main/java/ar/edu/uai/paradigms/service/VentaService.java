package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Venta;

public interface VentaService {
	public Venta saveVenta(Venta venta);
	public Venta retrieveVenta(long identifier);
	public Collection<Venta> listarVentas();
	
	
}
