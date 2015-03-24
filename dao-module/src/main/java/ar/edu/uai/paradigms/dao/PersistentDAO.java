package ar.edu.uai.paradigms.dao;

/**
 * Created by Federico on 19/10/2014.
 */
public interface PersistentDAO<ENTITY, IDENTIFIER> {
    public ENTITY create(ENTITY entity);
    public ENTITY retrieve(IDENTIFIER id);
    public ENTITY update(ENTITY entity);
    public void delete(IDENTIFIER id);
}
