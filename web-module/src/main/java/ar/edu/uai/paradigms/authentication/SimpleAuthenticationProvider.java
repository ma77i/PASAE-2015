package ar.edu.uai.paradigms.authentication;

import ar.edu.uai.paradigms.service.LoginService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico on 24/03/2015.
 */
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    public SimpleAuthenticationProvider(LoginService loginService) {
        super();
        this.loginService = loginService;
    }


    private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        String role = loginService.authenticate(name, password);
        Boolean userActive = loginService.isUserActive (name,password);


            if (role != null) {
                    if (userActive){
                        List<GrantedAuthority> grants = new ArrayList();
                        grants.add(new SimpleGrantedAuthority(role));
                        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString(), grants);
                    }
                    else throw new DisabledException("SU CUENTA HA SIDO DESACTIVADA");
            }
            else throw new UsernameNotFoundException("USUARIO Y/O PASSWORD INCORRECTOS");


    }

//        if (name.equals("admin") && password.equals("admin")) {
//            List<GrantedAuthority> grants = new ArrayList();
//            grants.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            return new UsernamePasswordAuthenticationToken(name, password, grants);
//        } else {
//            return null;
//        }


    public static String getUserLogged(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
    	return !(auth instanceof AnonymousAuthenticationToken) ? auth.getPrincipal().toString() : null;
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