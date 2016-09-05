package ar.edu.uai.paradigms.dao;

import java.util.Collection;

import ar.edu.uai.model.Asiento;


/**
 * Created by Federico on 19/10/2014.
 */

//La interface GenericDAO deberia incluir los metodos comunes a todas las entidades

public interface GenericDAO<T> {
    public Class<T> getPersistentClass();
	public void setPersistentClass(Class<T> persistentClass);
    public T create(T entity);
    public T retrieve(Class<T>tipo,long identifier);
    public T update(T entity);
    public void delete(long identifier);
    public Collection<T> list();
    public Collection<T> retrieveCollection(Class<T> tipo, Collection<Long> identifier);

}
