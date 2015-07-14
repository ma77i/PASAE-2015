package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;

import java.util.Collection;

public interface FuncionService {
	public Funcion saveFuncion(Funcion funcion, long espectaculoId);

	public Funcion retrieveFuncion(long id_funcion);

	public void deleteFuncion(long id_funcion);
	
	public Collection<Funcion> listarFunciones();
	
	public Funcion modificarFuncion(Funcion funcion);

	void agregarFuncionParaEspectaculo(Funcion savedFuncion, Espectaculo espectaculo);

	Collection<Funcion> listarFuncionesDeEspectaculo(long id_espectaculo);
	
}
