package ar.edu.uai.paradigms.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Matias on 31/07/2015.
 */
public class AsientoDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
