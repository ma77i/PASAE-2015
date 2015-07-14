package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Funcion;

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
}
