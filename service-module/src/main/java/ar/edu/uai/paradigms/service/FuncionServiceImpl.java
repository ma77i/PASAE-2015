package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dao.FuncionDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class FuncionServiceImpl implements FuncionService{
	

	private FuncionDAO funcionDAO;

	private EspectaculoService espectaculoService;

	public FuncionDAO getFuncionDAO() {
		return funcionDAO;
	}

	@Required
	public void setFuncionDAO(FuncionDAO funcionDAO) {
		this.funcionDAO = funcionDAO;
	}


	public void setEspectaculoService(EspectaculoService espectaculoService) {
		this.espectaculoService = espectaculoService;
	}

	
	@Transactional
	/**
	 * Antes recibia una ID ahora recibe un espectaculo object
	 *
	 * @deprecated use {@link #new()} instead.  
	 */
	@Deprecated
	public Funcion saveFuncion(Funcion funcion, long espectaculoId) {
		Espectaculo espectaculo = espectaculoService.retrieveEspectaculo(espectaculoId);
		this.agregarFuncionParaEspectaculo(funcion, espectaculo);
		return funcionDAO.update(funcion);
	}
	
	@Transactional
	public Funcion saveFuncion(Funcion funcion) {
		Espectaculo espectaculo = espectaculoService.retrieveEspectaculo(funcion.getEspectaculo().getId());
		for (Sector s : funcion.getSectores()) {
			 s.setFuncion(funcion);
		}
		this.agregarFuncionParaEspectaculo(funcion, espectaculo);
		return funcionDAO.update(funcion);
	}

	@Override
	public Funcion retrieveFuncion(long id_funcion) {
		return funcionDAO.retrieve(Funcion.class, id_funcion);
	}

	@Transactional
	public void deleteFuncion(long id_funcion) {
		this.funcionDAO.delete(id_funcion);
	}

	@Override
	public Collection<Funcion> listarFunciones() {
		return funcionDAO.list();
	}

	@Override
	public Funcion modificarFuncion(Funcion funcion) {
		Funcion f = this.retrieveFuncion(funcion.getId());
		f.setFecha(funcion.getFecha());
		//	f.setHora(funcion.getHora());
		return funcionDAO.update(funcion);
	}

	@Override
	public void agregarFuncionParaEspectaculo(Funcion savedFuncion, Espectaculo espectaculo) {
		savedFuncion.setEspectaculo(espectaculo);
		espectaculo.getFunciones().add(savedFuncion);
	}

	@Override
	public Collection<Funcion> listarFuncionesDeEspectaculo(long id_espectaculo) {
		return funcionDAO.listarFuncionesDeEspectaculo(id_espectaculo);
	}

	@Override
	public Long cantidadVentasDeFuncion(long id_funcion) {
		return funcionDAO.cantidadVentasDeFuncion(id_funcion);
	}



}
