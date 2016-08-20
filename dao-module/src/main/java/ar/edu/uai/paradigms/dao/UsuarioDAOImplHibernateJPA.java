package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Usuario;

import javax.persistence.NoResultException;
import javax.persistence.Query;


public class UsuarioDAOImplHibernateJPA<T> extends GenericDaoHibernateJPA<T> implements UsuarioDAO<T> {


    public UsuarioDAOImplHibernateJPA() {

    }

    /**
     * Segun el tipo de usuario retorno el nivel de acceso (definido en string) que le concedo,basado en el class name.
     */
    @Override
    public String getUserRole(String email,String password){
    	String role = null;
        Usuario user = null;
        try {
            Query consulta =
                    this.entityManager.createQuery("select u from Usuario as u where u.email=:email and u.password = :password");
            consulta.setParameter("email", email );
            consulta.setParameter("password", password);
            user = (Usuario) consulta.getSingleResult();
        }
        catch (NoResultException e) {
            user = null;
        }
        if(user!=null){
        	//ClassName
        	role = "ROLE_" + user.getClass().getSimpleName().toUpperCase();
        }
    	return role;
    	
    }

    @Override
    public Boolean isUserActive (String email, String password) {

        Usuario user;

        try {

            Query consulta=this.entityManager.createQuery("select u from Usuario as u where u.email=:email and u.password=:password and u.estado='activo'");
            consulta.setParameter("email", email );
            consulta.setParameter("password", password);
            user= (Usuario)consulta.getSingleResult();
        }
        catch (NoResultException e) {

            return false;

        }

        return true;
    }


    @Override
	public Usuario retrieveByUserName(String username) {
        try {
            Query consulta = this.entityManager.createQuery("select u.email from Usuario as u where u.email=:email");
            consulta.setParameter("email", username);
            return (Usuario) consulta.getSingleResult();
        }
        catch (NoResultException e) {
            System.out.println(" NO HAY UN USUARIO CON ESE MAIL");
            return null;
        }
	}


}
