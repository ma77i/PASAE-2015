package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.ex.CustomUnexpectedEx;
import org.hibernate.HibernateException;

import javax.persistence.Query;
import java.util.Collection;

public class FuncionDAOImplHibernateJPA extends GenericDaoHibernateJPA<Funcion>
implements FuncionDAO {


    public  FuncionDAOImplHibernateJPA(){
        this.setPersistentClass(Funcion.class);
    }

    /**
     * Lista todas las funciones de un espectaculo
     */

    @Override
    public Collection<Funcion> listarFuncionesDeEspectaculo(long id_espectaculo) {
        Query consulta = this.entityManager.createQuery("select f from Espectaculo as e join e.funciones as f where e.id=?");
        consulta.setParameter(1, id_espectaculo);
        return consulta.getResultList();
    }

    /**
     Devuelve la cantidad de ventas que tiene asociada una funcion
     */

    @Override
    public Long cantidadVentasDeFuncion(long id_funcion) {

        try {
            Query consulta = this.entityManager.createQuery("select count(v) from Venta as v where v.funcion.id=?");
            consulta.setParameter(1, id_funcion);
            return (Long) consulta.getSingleResult();

        }catch (HibernateException ex) {

            throw new CustomUnexpectedEx("Unexpected error " + ex.getLocalizedMessage());

        } catch (Exception ex) {
            throw new CustomUnexpectedEx("Unexpected error: " + ex.getLocalizedMessage());

        }


    }
}
