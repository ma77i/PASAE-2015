package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Espectaculo;

import javax.persistence.Query;
import java.util.Collection;

public class EspectaculoDAOImplHibernateJPA extends GenericDaoHibernateJPA<Espectaculo> implements EspectaculoDAO {

    @Override
    public Collection<Espectaculo> listarEspectaculosDeTeatro(long id_teatro){
        Query consulta=this.entityManager.createQuery("from Espectaculo as e where e.teatro.id=?");
        consulta.setParameter(1,id_teatro);
        return consulta.getResultList();
    }
}
