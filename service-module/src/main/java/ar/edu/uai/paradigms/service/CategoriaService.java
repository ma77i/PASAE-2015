package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Categoria;

import java.util.Collection;

/**
 * Created by Matias on 30/06/2015.
 */
public interface CategoriaService {

    Categoria saveCategoria(Categoria categoria);

    Categoria retrieveCategoria(long id_categoria);

    Categoria modificarCategoria(Categoria categoria);

    void deleteCategoria(long id_categoria);

    Collection<Categoria> listarCategorias();


}
