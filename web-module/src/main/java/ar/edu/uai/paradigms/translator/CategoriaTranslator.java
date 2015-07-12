package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Categoria;
import ar.edu.uai.paradigms.dto.CategoriaDTO;


/**
 * Created by Matias on 30/06/2015.
 */
public class CategoriaTranslator {

    public Categoria translate(CategoriaDTO categoriaDTO) {
        return new Categoria(categoriaDTO.getNombre());
    }

    public CategoriaDTO translateToDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getNombre(), categoria.getId());
    }


}
