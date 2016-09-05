package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dao.VentaDAO;
import ar.edu.uai.paradigms.ex.CustomValidationEx;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public class VentaServiceImpl implements VentaService {

	private VentaDAO ventaDAO;

	private TarjetaService tarjetaService;

	private EspectaculoService espectaculoService;

	private FuncionService funcionService;

	private EspectadorService espectadorService;

	private SectorService sectorService;
	
	private AsientoService asientoService;


	public VentaServiceImpl(){
		
	}

	public VentaServiceImpl(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}


	public void setAsientoService(AsientoService asientoService) {
		this.asientoService = asientoService;
	}

	public VentaDAO getVentaDAO() {
		return ventaDAO;
	}

	@Required
	public void setVentaDAO(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	public void setSectorService(SectorService sectorService) {
		this.sectorService = sectorService;
	}

	public void setEspectaculoService(EspectaculoService espectaculoService) {
		this.espectaculoService = espectaculoService;
	}

	public void setEspectadorService(EspectadorService espectadorService) {
		this.espectadorService = espectadorService;
	}

	public void setFuncionService(FuncionService funcionService) {
		this.funcionService = funcionService;
	}

	public void setTarjetaService(TarjetaService tarjetaService) {
		this.tarjetaService = tarjetaService;
	}

	@Transactional
	public Venta saveVenta(Venta venta,long funcionId, String numeroTarjeta, String cvv, String username) {		
		Espectador e = this.espectadorService.retrieveEspectadorPorNombre(username);	
		if(e==null){
			throw new CustomValidationEx("Usuario invalido");	
		}
		if(!tarjetaService.verificandoDatosTarjeta(numeroTarjeta, cvv)){
			throw new CustomValidationEx("Datos de tarjeta invalidos");			
		}
		//Busco los asientos en la base
		Collection<Asiento> asientosVendidos=venta.getAsientos();
		venta.setAsientos(this.asientoService.retrieveAsientos(asientosVendidos));
		for (Asiento asiento : venta.getAsientos()) {
			if(asiento.isOcupado()){
				throw new CustomValidationEx("Asiento Ocupado actualmente");
			}
			asiento.setOcupado(true);
		}
		//this.agregarTarjetaParaVenta(venta,new Tarjeta(numeroTarjeta,Integer.valueOf(cvv),new Date()));
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
	public Collection<Venta> listarComprasDeEspectador(String username) {
		return ventaDAO.listarComprasDeEspectador(username);
	}

	@Override
	public Long calcularMontoFinal(Long id_sector, Integer cantidad_asientos) {
		//return (this.calcularMontoNeto(id_sector, id_espectaculo) - this.aplicarDescuento(id_espectaculo));
		return this.sectorService.retrieveSector(id_sector).getMonto() * cantidad_asientos;
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
		//venta.setTarjeta(tarjeta);
		//tarjeta.getVentas().add(venta);
	}


}
