package ar.edu.uai.paradigms.validators;


import ar.edu.uai.paradigms.dto.VentaDTO;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



/**
 * Created by Matias on 29/06/2015.
 */
public class VentaDTOValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return VentaDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        VentaDTO ventaDTO = (VentaDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "monto", "monto.required", "El campo 'monto' es requerido");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "costoAdicional", "costoAdicional.required", "El campo 'costoAdicional' es requerido");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaVenta", "fechaVenta.required", "El campo 'fechaVenta' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cuotas", "cuotas.required", "El campo 'cuotas' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cvv", "cvv.required","El campo 'cvv' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "funcionId", "funcionId.required", "El campo 'funcionId' es requerido");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "espectadorId", "espectadorId.required", "El campo 'espectadorId' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numeroTarjeta", "tarjetaId.required", "El campo 'tarjetaId' es requerido");


    }


}
