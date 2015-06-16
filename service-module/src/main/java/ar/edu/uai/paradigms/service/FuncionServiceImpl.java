package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.dao.FuncionDAO;

public class FuncionServiceImpl implements FuncionService{
	

	private FuncionDAO funcionDAO;

	public FuncionDAO getFuncionDAO() {
		return funcionDAO;
	}

	public void setFuncionDAO(FuncionDAO funcionDAO) {
		this.funcionDAO = funcionDAO;
	}

	@Override
	public Funcion saveFuncion(Funcion funcion) {
		 return funcionDAO.create(funcion);
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

}
