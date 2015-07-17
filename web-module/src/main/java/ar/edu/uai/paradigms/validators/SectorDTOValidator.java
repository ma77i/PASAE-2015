package ar.edu.uai.paradigms.validators;

import ar.edu.uai.paradigms.dto.SectorDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by EzequielPanoff on 16/7/15.
 */
public class SectorDTOValidator implements Validator {


    public SectorDTOValidator() {

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SectorDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SectorDTO sectorDTO= (SectorDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.required", "El campo 'nombre' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "monto", "monto.required", "El campo 'monto' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "asientos_libres", "asientos_libres.required", "El campo 'asientos_libres' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nro_asientos", "nro_asientos.required", "El campo 'nro_asientos' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nro_filas", "nro_filas.required", "El campo 'nro_filas' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id_espectaculo", "id_espectaculo.required", "El campo 'id_espectaculo' es requerido");


    }
}