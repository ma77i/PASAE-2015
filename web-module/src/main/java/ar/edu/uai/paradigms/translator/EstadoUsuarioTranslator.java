package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Categoria;
import ar.edu.uai.paradigms.dto.CategoriaDTO;

/**
 * Created by Ezequiel on 28/07/2015.
 */
public class EstadoUsuarioTranslator {

    public CategoriaDTO translateToDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getNombre(), categoria.getId());
    }
}
