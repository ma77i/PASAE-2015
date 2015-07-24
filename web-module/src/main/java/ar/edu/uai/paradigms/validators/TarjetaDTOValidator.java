package ar.edu.uai.paradigms.validators;


import ar.edu.uai.paradigms.dto.TarjetaDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Created by Matias on 29/06/2015.
 */
public class TarjetaDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TarjetaDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TarjetaDTO tarjetaDTO = (TarjetaDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nro_tarjeta", "nro_tarjeta.required", "El campo 'nro_tarjeta' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cvv", "cvv.required", "El campo 'cvv' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha_vencimiento", "fecha_vencimiento.required", "El campo 'fecha_vencimiento' es requerido");

    }

}
