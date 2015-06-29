package ar.edu.uai.paradigms.service;

import java.util.Collection;
import java.util.Date;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.dao.FuncionDAO;
import org.springframework.beans.factory.annotation.Required;

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
		return funcionDAO.update(funcion);
	}



	@Override
	public Collection<Funcion> listarFuncionesEntreFechas(Date fecha1, Date fecha2) {
		return funcionDAO.listarFuncionesEntreFechas(fecha1,fecha2);
	}

	private void agregarFuncionParaEspectaculo(Funcion savedFuncion, Espectaculo espectaculo) {
	   espectaculo.getFunciones().add(savedFuncion);
	   espectaculoService.saveEspectaculo(espectaculo);
	}

}
