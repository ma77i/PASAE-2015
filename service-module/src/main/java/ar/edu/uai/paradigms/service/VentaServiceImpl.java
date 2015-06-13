package ar.edu.uai.paradigms.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dao.VentaDAO;

public class VentaServiceImpl implements VentaService {

	private VentaDAO ventaDAO;
	
	public VentaServiceImpl(){
		
	}

	public VentaServiceImpl(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	public VentaDAO getVentaDAO() {
		return ventaDAO;
	}

	public void setVentaDAO(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	@Transactional
	public Venta saveVenta(Venta venta) {
		return ventaDAO.create(venta);
	}

	@Override
	public Venta retrieveVenta(long identifier) {

		return ventaDAO.retrieve(Venta.class, identifier);
	}

	@Override
	public Collection<Venta> listarVentas() {
		return ventaDAO.list();

	}

	@Override
	public Collection<Venta> listarComprasDeEspectador(long id_espectador) {
		return ventaDAO.listarComprasDeEspectador(id_espectador);
	}

	@Override
	public Float calcularMontoFinal() {
		return null;
	}

	@Override
	public Float calcularCostoNeto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float aplicarDescuento() {
		// TODO Auto-generated method stub
		return null;
	}

}
