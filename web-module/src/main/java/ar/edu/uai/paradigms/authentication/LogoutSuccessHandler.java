package ar.edu.uai.paradigms.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

	   // Just for setting the default target URL
	   public LogoutSuccessHandler(String defaultTargetURL) {
	        this.setDefaultTargetUrl(defaultTargetURL);
	   }

	   @Override
	   public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

	        // do whatever you want
//	        super.onLogoutSuccess(request, response, authentication);
           JSONObject json = new JSONObject();
           response.setContentType("application/json");
           json.put("Result", "success");
           response.getWriter().write(json.toString());
	   }
	}