package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Sector;

import javax.persistence.Query;
import java.util.Collection;
import java.util.Date;

public class FuncionDAOImplHibernateJPA extends GenericDaoHibernateJPA<Funcion>
implements FuncionDAO {


    public  FuncionDAOImplHibernateJPA(){
        this.setPersistentClass(Funcion.class);
    }


    /**
     * Lista todas las funciones entre un rango de fechas
     */
    @Override
    public Collection<Funcion> listarFuncionesEntreFechas(Date startDate, Date endDate) {
        Query consulta=this.entityManager.createQuery("select f from Funcion as f where f.fecha BETWEEN :startDate AND :endDate");
        consulta.setParameter(1, endDate);
        consulta.setParameter(2,endDate);
        return consulta.getResultList();

    }
}
