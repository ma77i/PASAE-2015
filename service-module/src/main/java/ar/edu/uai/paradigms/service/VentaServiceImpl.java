package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dao.VentaDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class VentaServiceImpl implements VentaService {

	private VentaDAO ventaDAO;

	private TarjetaService tarjetaService;

	private EspectaculoService espectaculoService;

	private FuncionService funcionService;

	private EspectadorService espectadorService;


	public VentaServiceImpl(){
		
	}

	public VentaServiceImpl(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	public VentaDAO getVentaDAO() {
		return ventaDAO;
	}

	@Required
	public void setVentaDAO(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	@Transactional
	public Venta saveVenta(Venta venta, Long espectaculoId, Long funcionId, Long espectadorId, Long tarjetaId) {
		Espectador e = this.espectadorService.retrieveUsuario(espectaculoId);
		this.agregarTarjetaParaVenta(venta, this.tarjetaService.retrieveTarjeta(tarjetaId));
		this.agregarFuncionParaVenta(venta, this.funcionService.retrieveFuncion(funcionId));
		this.agregarEspectadorParaVenta(venta, e);
		this.agregarVentaParaEspectador(venta);
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
	public void agregarVentaParaEspectador(Venta venta) {
		venta.getComprador().getCompras().add(venta);
	}

	@Override
	public void agregarFuncionParaVenta(Venta venta, Funcion funcion) {
		venta.setFuncion(funcion);
		funcion.getVentas().add(venta);

	}

	@Override
	public void agregarEspectadorParaVenta(Venta venta, Espectador espectador) {
		venta.setComprador(espectador);
		espectador.getCompras().add(venta);
	}

	@Override
	public void agregarTarjetaParaVenta(Venta venta, Tarjeta tarjeta) {
		venta.setTarjeta(tarjeta);
		tarjeta.getVentas().add(venta);
	}

}
