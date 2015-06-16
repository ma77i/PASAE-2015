package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Funcion;

public interface FuncionService {
	public Funcion saveFuncion(Funcion funcion);

	public Funcion retrieveFuncion(long id_funcion);

	public void deleteFuncion(long id_funcion);
	
	public Collection<Funcion> listarFunciones();
	
	public Funcion modificarFuncion(Funcion funcion);

	
}
