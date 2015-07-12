package ar.edu.uai.paradigms.dao;

import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public T create(T entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	@Transactional
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
		Query consulta = this.entityManager.createQuery(" from " + getPersistentClass().getSimpleName());
		Collection<T> resultado = consulta.getResultList();
		return resultado;
	}
}
