package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Funcion;

import java.util.Collection;
import java.util.Date;

public interface FuncionDAO extends GenericDAO<Funcion> {
     Collection<Funcion> listarFuncionesEntreFechas(Date fecha1, Date fecha2);

}
