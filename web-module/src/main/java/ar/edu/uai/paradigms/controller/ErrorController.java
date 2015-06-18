package ar.edu.uai.paradigms.controller;

import javassist.tools.web.BadHttpRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Ezequiel on 17/06/2015.
 */

@Controller
public abstract class ErrorController {


    @ExceptionHandler({EmptyResultDataAccessException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "ERROR EN BD")
    public void notFound() {
    }

    @ExceptionHandler({DataAccessException.class, SQLException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "RECURSO NO ENCONTRADO")
    public @ResponseBody String dataAccessException(Exception ex, HttpServletResponse response) {
        response.setHeader("Content-Type", "application/json");
        return "Unknown error occurred: " + ex.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    public String preconditionFailed(IllegalArgumentException e) {
        return e.getLocalizedMessage();
    }

    @ExceptionHandler(BadHttpRequest.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "URL INVALIDA")
    public void badRequestException() {
    }


  /*  @ExceptionHandler(Exception.class)
    public
    @ResponseBody
    String handleUncaughtException(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {

        response.setHeader("Content-Type", "application/json");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return "Unknown error occurred: " + ex.getMessage();


    }
*/

}
