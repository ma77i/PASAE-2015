package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Funcion;

import java.util.Collection;

public interface FuncionDAO extends GenericDAO<Funcion> {
     Collection<Funcion> listarFuncionesDeEspectaculo(long id_espectaculo);

     Long cantidadVentasDeFuncion(long id_funcion);
}
