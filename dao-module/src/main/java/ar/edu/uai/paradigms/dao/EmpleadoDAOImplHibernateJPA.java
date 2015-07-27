package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Empleado;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Collection;

public class EmpleadoDAOImplHibernateJPA extends UsuarioDAOImplHibernateJPA <Empleado> implements EmpleadoDAO {

    public EmpleadoDAOImplHibernateJPA() {
         this.setPersistentClass(Empleado.class);
    }

    @Override
    public Collection<Empleado> listarEmpleadosPorCampoIngresado(String input) {
        try {
            Query consulta = this.entityManager.createQuery("select e from Empleado as e where LOWER(e.nombre) LIKE LOWER(:input) or LOWER(e.apellido) LIKE LOWER(:input) or LOWER(e.email) LIKE LOWER(:input)");
            consulta.setParameter("input", input + "%");
            return consulta.getResultList();
        } catch (NoResultException e) {
            System.out.println("NO SE ENCONTRO LA BUSQUEDA");
            return null;
        }
    }
}
