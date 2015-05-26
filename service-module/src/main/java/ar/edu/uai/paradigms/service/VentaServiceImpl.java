package ar.edu.uai.paradigms.service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta retrieveVenta(long identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
