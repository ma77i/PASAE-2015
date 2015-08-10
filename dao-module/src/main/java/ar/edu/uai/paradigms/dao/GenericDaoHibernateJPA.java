package ar.edu.uai.paradigms.dao;

import ar.edu.uai.paradigms.ex.CustomLockingFailureEx;
import ar.edu.uai.paradigms.ex.CustomQueryEx;
import ar.edu.uai.paradigms.ex.CustomResourceNotFoundEx;
import ar.edu.uai.paradigms.ex.CustomUnexpectedEx;
import org.hibernate.QueryException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

public abstract class GenericDaoHibernateJPA<T> implements GenericDAO<T> {
	@PersistenceContext(unitName = "paradigms-persistence-unit")
	public EntityManager entityManager;
	public Class<T> persistentClass;

	public GenericDaoHibernateJPA(){

	}

	
	public GenericDaoHibernateJPA(Class<T>persistentClass) {
		this.persistentClass=persistentClass;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	public T create(T entity) {

		try {
			this.entityManager.persist(entity);
			return entity;
		}
		catch (OptimisticLockingFailureException e) {
			throw new CustomLockingFailureEx("Failure to lock database. Try Later");
		}



		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}
	}

	@Override
	public T update(T entity) {

		try {
			return this.entityManager.merge(entity);

		}
		catch (OptimisticLockingFailureException e) {
			throw new CustomLockingFailureEx("Failure to lock database. Try Later");
		}
		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}

	}

	@Override
	public T retrieve(Class<T>tipo,long identifier) {
		T entity;
		try {
			entity = this.entityManager.find(tipo, identifier);
			if (entity != null)
				return entity;
			else
				throw new CustomResourceNotFoundEx("");
		}
		catch (CustomResourceNotFoundEx ex){
			throw new CustomResourceNotFoundEx("There is no resource '" + tipo.getSimpleName() + "' with identifier '" + identifier + "'");
		}
		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}

	}

	@Override
	public void delete(long identifier) {
		try {
			this.entityManager.remove(this.retrieve(getPersistentClass(), identifier));
		}
		catch (OptimisticLockingFailureException e) {
			throw new CustomLockingFailureEx("Failure to lock database. Try Later");
		}
		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}
	}

	@Override
	public Collection<T> list() {

		try {
			Query consulta = this.entityManager.createQuery(" from " + getPersistentClass().getSimpleName());
			Collection<T> resultado = consulta.getResultList();
			return resultado;

		}
		catch (EmptyResultDataAccessException e) {
			throw new CustomResourceNotFoundEx("Resource not found (empty set value)");
		}

		catch (QueryException e) {
			throw new CustomQueryEx("DB error: couldn't execute query statement");
		}

		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}
	}
}
