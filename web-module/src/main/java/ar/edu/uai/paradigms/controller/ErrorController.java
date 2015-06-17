package ar.edu.uai.paradigms.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

/**
 * Created by Ezequiel on 17/06/2015.
 */
public abstract class ErrorController {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="RECURSO NO ENCONTRADO")
    public void notFound() { }

    @ExceptionHandler({DataAccessException.class,SQLException.class,Exception.class})
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="ERROR ACCESO DB")
    public void dataAccessException() {
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value=HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    public String preconditionFailed(IllegalArgumentException e) {
        return e.getLocalizedMessage();
    }

}
