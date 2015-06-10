package ar.edu.uai.paradigms.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDaoHibernateJPA<T> implements GenericDAO<T> {
	@PersistenceContext(unitName = "paradigms-persistence-unit")
	public EntityManager entityManager;
	public Class<T> persistentClass;

	
/*	public GenericDaoHibernateJPA() {
		persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
		//obtener el tipo por reflexion
	}
*/
	@Override
	public T create(T entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		return this.entityManager.merge(entity);
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
	public T retrieve(Class<T>tipo,long identifier) {
		return this.entityManager.find(tipo, identifier);
	}

	@Override
	public void delete(long identifier) {
		this.entityManager.remove(this.retrieve(getPersistentClass(),identifier));

	}

	@Override
	public Collection<T> list() {
		Query consulta = this.entityManager.createQuery("from"
				+ getPersistentClass().getSimpleName());
		Collection<T> resultado = consulta.getResultList();
		return resultado;
	}
}
