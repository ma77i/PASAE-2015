package ar.edu.uai.paradigms.controller;

import ar.edu.uai.paradigms.customex.CustomResourceNotFoundEx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by EzequielPanoff on 24/6/15.
 */

@Controller
@RequestMapping("/*")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET, value = "/**")
    public void unnmapedRequest (HttpServletRequest request) {
        String uri = request.getRequestURI();
        throw new CustomResourceNotFoundEx("El recurso para el path " + "'" + uri + "'" + " no existe");
    }
}
