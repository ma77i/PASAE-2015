package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Sector;


public interface EspectaculoService {
	public Espectaculo saveEspectaculo(Espectaculo espectaculo);

	public Espectaculo retrieveEspectaculo(long identifier);

	public void deleteEspectaculo(long identifier);
	
	public Collection<Espectaculo> listarEspectaculos();
	
	public Espectaculo modificarEspectaculo(Espectaculo espectaculo);

	public Collection<Espectaculo> listarEspectaculosDeTeatro(long id_teatro);

	public Funcion getFuncionDeEspectaculo(long id_funcion);

}
