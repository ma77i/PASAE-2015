package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Teatro;

public class TeatroDAOImplHibernateJPA extends GenericDaoHibernateJPA<Teatro> implements TeatroDAO {

    public TeatroDAOImplHibernateJPA(){

        this.setPersistentClass(Teatro.class);
    }


}
