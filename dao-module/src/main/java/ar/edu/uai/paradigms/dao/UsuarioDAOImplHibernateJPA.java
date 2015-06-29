package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Administrador;
import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;

import javax.persistence.NoResultException;
import javax.persistence.Query;


public class UsuarioDAOImplHibernateJPA<T> extends GenericDaoHibernateJPA<T> implements UsuarioDAO<T> {


    public UsuarioDAOImplHibernateJPA() {

    }



    @Override
    public Usuario existeUsuario(String email) {
        try {

            Query consulta = this.entityManager.createQuery("select u.email from Usuario as u where u.email=:email");
            consulta.setParameter("email", email);
            return (Usuario) consulta.getSingleResult();
        }
        catch (NoResultException e) {

            System.out.println(" NO HAY UN USUARIO CON ESE MAIL");
            return null;
        }
    }
    
    /**
     * Segun el tipo de usuario retorno el nivel de acceso (definido en string) que le concedo,basado en el class name.
     */
    @Override
    public String getUserRole(String email,String password){
    	String role = "ROLE_ANON";
        Usuario user = null;
        try {
            Query consulta = this.entityManager.createQuery("select u from Usuario as u where u.mail=:email and u.password = :password");
            consulta.setParameter("email", email );
            consulta.setParameter("password", password);
            user = (Usuario) consulta.getSingleResult();
        }
        catch (NoResultException e) {
            user = null;
        }        
        if(user!=null){
        	//ClassName
        	role = "ROLE_" + user.getClass();
        }
    	return role;
    	
    }


}
