package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Categoria;

/**
 * Created by Matias on 30/06/2015.
 */
public class CategoriaDAOImplHibernateJPA extends GenericDaoHibernateJPA<Categoria> implements CategoriaDAO {

    public CategoriaDAOImplHibernateJPA() {
        this.setPersistentClass(Categoria.class);
    }


}
