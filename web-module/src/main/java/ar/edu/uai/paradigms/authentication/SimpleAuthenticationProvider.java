package ar.edu.uai.paradigms.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ar.edu.uai.paradigms.service.LoginService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico on 24/03/2015.
 */
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    public SimpleAuthenticationProvider(LoginService loginService){
        super();
        this.loginService=loginService;
    }


    private LoginService loginService ;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        String role = loginService.authenticate(name,password);
        if(role != null){
        	List<GrantedAuthority> grants = new ArrayList();
        	grants.add(new SimpleGrantedAuthority(role));
        	return new UsernamePasswordAuthenticationToken(authentication.getName(),  authentication.getCredentials().toString(), grants);
        }else{
        	return null;
        }
        
//        if (name.equals("admin") && password.equals("admin")) {
//            List<GrantedAuthority> grants = new ArrayList();
//            grants.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            return new UsernamePasswordAuthenticationToken(name, password, grants);
//        } else {
//            return null;
//        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}