package ar.edu.uai.paradigms.validators;

import ar.edu.uai.paradigms.dto.TeatroDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Matias on 29/06/2015.
 */
public class TeatroDTOValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return TeatroDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TeatroDTO teatroDTO = (TeatroDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.required", "El campo 'nombre' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion", "direccion.required", "El campo 'direccion' es requerido");
    }


}
