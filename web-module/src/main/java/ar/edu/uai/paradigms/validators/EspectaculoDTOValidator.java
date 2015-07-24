package ar.edu.uai.paradigms.validators;

import ar.edu.uai.paradigms.dto.EspectaculoDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Matias on 29/06/2015.
 */
public class EspectaculoDTOValidator implements Validator {

    public EspectaculoDTOValidator() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return EspectaculoDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EspectaculoDTO espectaculoDTO = (EspectaculoDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.required", "El campo 'nombre' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "descripcion.required", "El campo 'descripcion' es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoriaId", "categoriaId.required", "El campo 'categoriaId' es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "teatroId", " teatroId.required", "El campo ' teatroId' es obligatorio");
    }


}
