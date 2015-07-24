package ar.edu.uai.paradigms.validators;

import ar.edu.uai.paradigms.dto.FuncionDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Created by Matias on 29/06/2015.
 */
public class FuncionDTOValidator implements Validator {

    public FuncionDTOValidator() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FuncionDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FuncionDTO funcionDTO = (FuncionDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha", "fecha.required", "El campo 'fecha' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hora", "hora.required", "El campo 'hora' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "espectaculoId", "espectaculoId.required", "El campo 'espectaculoId' es requerido");

    }


}
