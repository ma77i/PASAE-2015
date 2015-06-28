package ar.edu.uai.paradigms.validators;

import ar.edu.uai.model.Usuario;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Ezequiel on 27/06/2015.
 */
public class UsuarioValidator implements Validator {


    public UsuarioValidator() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario= (Usuario) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "apellido.required");

    }
}
