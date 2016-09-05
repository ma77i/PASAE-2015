package ar.edu.uai.paradigms.dao;

import ar.edu.uai.paradigms.ex.*;

import org.hibernate.QueryException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
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
		} catch (PersistenceException e) {
			Throwable t = e.getCause();
			while ((t != null) && !(t instanceof ConstraintViolationException)) {
				t = t.getCause();
			}
			if (t instanceof ConstraintViolationException) {
				// Here you're sure you have a ConstraintViolationException, you can handle it
				throw new CustomValidationEx("El " + entity.getClass().getSimpleName().toLowerCase() + " ya existe");
			}

		}
		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}
		return entity;
	}


	@Override
	public T update(T entity) {

		try {
			return this.entityManager.merge(entity);

		}
		catch (OptimisticLockingFailureException e) {
			throw new CustomLockingFailureEx("Failure to lock database. Try Later");
		} catch (PersistenceException e) {
			Throwable t = e.getCause();
			while ((t != null) && !(t instanceof ConstraintViolationException)) {
				t = t.getCause();
			}
			if (t instanceof ConstraintViolationException) {
				// Here you're sure you have a ConstraintViolationException, you can handle it
				throw new CustomValidationEx("El " + entity.getClass().getSimpleName().toLowerCase() + " ya existe");
			}

		}

		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}
		return entity;

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
			int test = 0;
			Query consulta; 
			consulta = this.entityManager.createQuery(" from " + getPersistentClass().getSimpleName());
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
	 
	@Override
	public Collection<T> retrieveCollection(Class<T>tipo,Collection<Long> identifier) {
		try {
			int test = 0;
			Query consulta; 
			consulta = this.entityManager.createQuery(" from " + tipo.getSimpleName()+" where id  IN (:identificadores)");
			consulta.setParameter("identificadores", identifier);
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
