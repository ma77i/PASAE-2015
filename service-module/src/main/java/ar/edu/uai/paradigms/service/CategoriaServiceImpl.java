package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Categoria;
import ar.edu.uai.paradigms.dao.CategoriaDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Matias on 30/06/2015.
 */
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaDAO categoriaDAO;

    public CategoriaServiceImpl() {

    }

    @Required
    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Transactional
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaDAO.create(categoria);
    }

    @Override
    public Categoria retrieveCategoria(long id_categoria) {
        return categoriaDAO.retrieve(Categoria.class, id_categoria);
    }

    @Override
    public Categoria modificarCategoria(Categoria categoria) {
        Categoria c = this.retrieveCategoria(categoria.getId());
        c.setNombre(categoria.getNombre());
        return categoriaDAO.update(c);
    }

    @Override
    @Transactional
    public void deleteCategoria(long id_categoria) {
        categoriaDAO.delete(id_categoria);
    }

    @Override
    public Collection<Categoria> listarCategorias() {
        return categoriaDAO.list();
    }


}
