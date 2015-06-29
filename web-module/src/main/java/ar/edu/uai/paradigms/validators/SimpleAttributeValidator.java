package ar.edu.uai.paradigms.validators;

import ar.edu.uai.paradigms.ex.CustomResourceNotFoundEx;

/**
 * Created by EzequielPanoff on 24/6/15.
 */
public class SimpleAttributeValidator  {

    public static Long validateId (Long id) {
        if (id == null)
            throw new CustomResourceNotFoundEx("El ID proporcionado es inválido");
        else
            return id;

    }



}
