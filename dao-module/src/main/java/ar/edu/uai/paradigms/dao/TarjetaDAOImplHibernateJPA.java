package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Tarjeta;

/**
 * Created by Matias on 22/06/2015.
 */
public class TarjetaDAOImplHibernateJPA extends GenericDaoHibernateJPA<Tarjeta> implements TarjetaDAO {

    public TarjetaDAOImplHibernateJPA() {

        this.setPersistentClass(Tarjeta.class);
    }


}
