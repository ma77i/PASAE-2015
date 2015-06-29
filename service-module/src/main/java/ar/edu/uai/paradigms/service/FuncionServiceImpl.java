package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.dao.FuncionDAO;
import org.springframework.beans.factory.annotation.Required;

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

	@Override
	public Funcion saveFuncion(Funcion funcion) {
		Funcion savedFuncion=funcionDAO.create(funcion);
		this.agregarFuncionParaEspectaculo(savedFuncion,espectaculoService.retrieveEspectaculo(funcion.getEspectaculo().getId()));
		return savedFuncion;
	}

	@Override
	public Funcion retrieveFuncion(long id_funcion) {
		return funcionDAO.retrieve(Funcion.class, id_funcion);
	}

	@Override
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
		f.setHora(funcion.getHora());
		return funcionDAO.update(funcion);
	}

	private void agregarFuncionParaEspectaculo(Funcion savedFuncion, Espectaculo espectaculo) {
	   espectaculo.getFunciones().add(savedFuncion);
	   espectaculoService.saveEspectaculo(espectaculo);
	}

	@Override
	public Collection<Funcion> listarFuncionesDeEspectaculo(long id_espectaculo) {
		return funcionDAO.listarFuncionesDeEspectaculo(id_espectaculo);
	}



}
