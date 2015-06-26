package ar.edu.uai.paradigms.authentication;

import ar.edu.uai.paradigms.customex.CustomUnauthorizedEx;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Federico on 24/03/2015.
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence( HttpServletRequest request, HttpServletResponse response,
                          AuthenticationException authException ) throws IOException, ServletException {
        throw new CustomUnauthorizedEx("No esta autorizado para aceeder al recurso");
    }
}
