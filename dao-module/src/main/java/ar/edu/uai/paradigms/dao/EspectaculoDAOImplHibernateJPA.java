package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;

import javax.persistence.Query;
import java.util.Collection;

public class EspectaculoDAOImplHibernateJPA extends GenericDaoHibernateJPA<Espectaculo> implements EspectaculoDAO {

    @Override
    public Collection<Espectaculo> listarEspectaculosDeTeatro(long id_teatro){
        Query consulta=this.entityManager.createQuery("from Espectaculo as e where e.teatro.id=?");
        consulta.setParameter(1,id_teatro);
        return consulta.getResultList();
    }

    @Override
    public Funcion listarFuncionesDeEspectaculo(long id_funcion) {
        Query consulta=this.entityManager.createQuery("select f from Espectaculo as e join e.funciones as f where f.id=?");
        consulta.setParameter(1,id_funcion);
        return (Funcion)consulta.getSingleResult();
    }




}
