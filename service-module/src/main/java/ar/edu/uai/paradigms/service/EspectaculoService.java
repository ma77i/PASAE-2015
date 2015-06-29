package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;

import java.util.Collection;
import java.util.Date;


public interface EspectaculoService {
	public Espectaculo saveEspectaculo(Espectaculo espectaculo);

	public Espectaculo retrieveEspectaculo(long identifier);

	public void deleteEspectaculo(long identifier);
	
	public Collection<Espectaculo> listarEspectaculos();
	
	public Espectaculo modificarEspectaculo(Espectaculo espectaculo);

	public Collection<Espectaculo> listarEspectaculosDeTeatro(long id_teatro);

	public Funcion getFuncionDeEspectaculo(long id_funcion);

	public String existeEspectaculo(String nombre_espectaculo);

	public Collection<Espectaculo>listarEspectaculosPorNombre(String nombre_espectaculo);

	Collection<Espectaculo> listarEspectaculosEntreFechas(Date fecha1, Date fecha2);

}
