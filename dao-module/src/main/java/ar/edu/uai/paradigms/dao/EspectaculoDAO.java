package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;

import java.util.Collection;
import java.util.Date;

public interface EspectaculoDAO extends GenericDAO<Espectaculo> {

    public Long cantidadEspectaculosDeTeatro(String nombre_teatro);
    public Funcion listarFuncionesDeEspectaculo(long id_funcion);
    public String existeEspectaculo(String nombre_espectaculo);
    public Collection<Espectaculo> listarEspectaculosPorNombre(String nombre_espectaculo);

    Collection<Espectaculo> listarEspectaculosEntreRangoDeFechas(Date startDate, Date endDate);

    Collection<Espectaculo> listarEspectaculosSegunCategoria(String nombre_categoria);

    Long cantidadFuncionesDeEspectaculo(long idEspectaculo);
}
