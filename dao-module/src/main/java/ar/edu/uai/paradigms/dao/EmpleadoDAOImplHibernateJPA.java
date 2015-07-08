package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Empleado;

public class EmpleadoDAOImplHibernateJPA extends UsuarioDAOImplHibernateJPA <Empleado> implements EmpleadoDAO {

    public EmpleadoDAOImplHibernateJPA() {
         this.setPersistentClass(Empleado.class);
    }

}
