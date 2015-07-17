package ar.edu.uai.paradigms.validators;

import ar.edu.uai.paradigms.dto.UsuarioDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Ezequiel on 27/06/2015.
 */
public class UsuarioDTOValidator implements Validator {


    public UsuarioDTOValidator() {

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UsuarioDTO usuarioDTO= (UsuarioDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required", "El campo 'email' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "El campo 'password' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.required", "El campo 'nombre' es requerido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "apellido.required", "El campo 'apellido' es requerido");

    }
}
