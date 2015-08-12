package ar.edu.uai.paradigms.dao;

import java.util.Date;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.model.Usuario;

/**
 * Created by Matias on 22/06/2015.
 */
public class TarjetaDAOImplHibernateJPA extends GenericDaoHibernateJPA<Tarjeta> implements TarjetaDAO {

    public TarjetaDAOImplHibernateJPA() {

        this.setPersistentClass(Tarjeta.class);
    }

	@Override
	public Tarjeta retrieveTarjetaByNumero(String numeroTarjeta, Integer cvv, Date date) {
		// TODO Auto-generated method stub
		Tarjeta tarjeta = null;
		try {
            Query consulta =
                    this.entityManager.createQuery("select t from Tarjeta as t where t.nro_tarjeta LIKE :numeroTarjeta");
            consulta.setParameter("numeroTarjeta", numeroTarjeta );            
            tarjeta = (Tarjeta) consulta.getSingleResult();
        }
        catch (NoResultException e) {
        	tarjeta = new Tarjeta(numeroTarjeta,cvv,date);
        }   
		return tarjeta;
	}
	
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



}
