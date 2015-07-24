package ar.edu.uai.paradigms.validators;

import ar.edu.uai.paradigms.dto.CategoriaDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by EzequielPanoff on 15/7/15.
 */
public class CategoriaDTOValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoriaDTO categoriaDTO = (CategoriaDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.required", "El campo 'nombre' es requerido");

    }
}
