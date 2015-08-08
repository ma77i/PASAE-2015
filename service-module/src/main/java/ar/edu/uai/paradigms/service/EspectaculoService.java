package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Categoria;
import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Teatro;

import java.util.Collection;
import java.util.Date;


public interface EspectaculoService {
	public Espectaculo saveEspectaculo(Espectaculo espectaculo,long categoriaId,long teatroId);

	public Espectaculo retrieveEspectaculo(long identifier);

	public void deleteEspectaculo(long identifier);
	
	public Collection<Espectaculo> listarEspectaculos();

	public Espectaculo modificarEspectaculo(Espectaculo e, String nombre, String descripcion, long teatroId);

	public Long listarEspectaculosDeTeatro(String nombre_teatro);

	public Funcion getFuncionDeEspectaculo(long id_funcion);

	public String existeEspectaculo(String nombre_espectaculo);

	public Collection<Espectaculo>listarEspectaculosPorNombre(String nombre_espectaculo);

	Collection<Espectaculo> listarEspectaculosEntreFechas(Date fecha1, Date fecha2);

	Collection<Espectaculo> listarEspectaculosSegunCategoria(String nombre_categoria);

	void agregarEspectaculoParaCategoria(Espectaculo e,Categoria categoria);

	void agregarEspectaculoParaTeatro(Espectaculo e,Teatro teatro);
}
