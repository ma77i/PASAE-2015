package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Federico on 19/10/2014.
 */
public class UsuarioDAO implements PersistentDAO<T , Long> {

    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Usuario create(Usuario usuario) {
        this.entityManager.persist(usuario);
        return usuario;
    }

    @Override
    public Usuario retrieve(Long id) {
        return this.entityManager.find(Usuario.class, id);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return this.entityManager.merge(usuario);
    }

    @Override
    public void delete(Long id) {
        this.entityManager.remove(this.retrieve(id));
    }

	

	
}
