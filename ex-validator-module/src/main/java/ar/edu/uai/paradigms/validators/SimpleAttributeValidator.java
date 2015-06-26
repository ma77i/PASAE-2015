package ar.edu.uai.paradigms.validators;

import ar.edu.uai.paradigms.customex.MyCustomException;

/**
 * Created by EzequielPanoff on 24/6/15.
 */
public class SimpleAttributeValidator  {

    public Long validateId (Long id) {
        if (id == null)
            throw new MyCustomException("El ID proporcionado es inválido");
        else
            return id;

    }




}
