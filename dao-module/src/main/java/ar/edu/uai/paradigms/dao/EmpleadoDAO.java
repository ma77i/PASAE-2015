package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Empleado;

import java.util.Collection;

public interface EmpleadoDAO extends UsuarioDAO<Empleado> {

    Collection<Empleado> listarEmpleadosPorCampoIngresado(String input);
}
