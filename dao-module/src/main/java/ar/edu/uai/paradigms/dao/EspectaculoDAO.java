package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Espectaculo;

import java.util.Collection;

public interface EspectaculoDAO extends GenericDAO<Espectaculo> {

    public Collection<Espectaculo> listarEspectaculosDeTeatro(long id_teatro);

}
