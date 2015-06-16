package ar.edu.uai.paradigms.validation;


import org.apache.commons.lang3.Validate;

/**
 * Created by Ezequiel on 15/06/2015.
 */



public final class Validator {

    public static  <T> T validateObject (T object){

        return Validate.notNull(object, "ID es inválido");
    }

}
