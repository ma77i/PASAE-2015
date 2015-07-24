package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Empleado;

import javax.persistence.Query;
import java.util.Collection;

public class EmpleadoDAOImplHibernateJPA extends UsuarioDAOImplHibernateJPA <Empleado> implements EmpleadoDAO {

    public EmpleadoDAOImplHibernateJPA() {
         this.setPersistentClass(Empleado.class);
    }

    @Override
    public Collection<Empleado> listarEmpleadosPorCampoIngresado(String input) {
        Query consulta = this.entityManager.createQuery("select e from Empleado as e where e.nombre LIKE :input or e.apellido LIKE :input or e.email LIKE :input");
        consulta.setParameter(1, "%" + input + "%");
        return consulta.getResultList();
    }
}
