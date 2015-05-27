package ar.edu.uai.paradigms.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dao.VentaDAO;

public class VentaServiceImpl implements VentaService {

	private VentaDAO ventaDAO;
	
	
	public VentaServiceImpl(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	@Transactional
	public Venta saveVenta(Venta venta) {
		 return ventaDAO.create(venta);
	}

	@Override
	public Venta retrieveVenta(long identifier) {
		
		return ventaDAO.retrieve(ventaDAO.getPersistentClass(), identifier);
	}

	@Override
	public Collection<Venta> listarVentas() {
		return null;
		
		
	}

	
	
	
}
