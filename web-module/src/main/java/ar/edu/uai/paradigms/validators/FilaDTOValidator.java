package ar.edu.uai.paradigms.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by EzequielPanoff on 31/7/15.
 */
public class FilaDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
