package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;

import java.util.Collection;

public interface EspectaculoDAO extends GenericDAO<Espectaculo> {

    public Collection<Espectaculo> listarEspectaculosDeTeatro(long id_teatro);
    public Funcion listarFuncionesDeEspectaculo(long id_funcion);
    public String existeEspectaculo(String nombre_espectaculo);
    public Collection<Espectaculo> listarEspectaculosPorNombre(String nombre_espectaculo);

}
