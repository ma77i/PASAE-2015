package ar.edu.uai.paradigms.authentication;

import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by EzequielPanoff on 19/8/16.
 */
public class SavedRequestAwareAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, javax.servlet.ServletException {


        JSONObject json = new JSONObject();
        response.setContentType("application/json");
        json.put("type", "401");
        json.put("title","UNAUTHORIZED");
        json.put("detail", exception.getLocalizedMessage());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(json.toString());

    }
}
