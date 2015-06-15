package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dao.VentaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

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
	public Float calcularMontoFinal(long id_sector, long id_espectaculo) {
		return (this.calcularMontoNeto(id_sector, id_espectaculo) - this.aplicarDescuento(id_espectaculo));
	}

	@Override
	public Float calcularMontoNeto(long id_sector, long id_espectaculo) {
		return ventaDAO.calcularMontoNeto(id_sector, id_espectaculo);

	}

	@Override
	public Float aplicarDescuento(long id_espectaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarVentaParaEspectador(Espectador espectador,Venta venta) {
          espectador.getCompras().add(venta);

	}

}
