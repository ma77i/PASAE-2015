
package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import java.util.Collection;


public class EspectadorDAOImplHibernateJPA extends UsuarioDAOImplHibernateJPA<Espectador> implements EspectadorDAO {


    public EspectadorDAOImplHibernateJPA() {
        this.setPersistentClass(Espectador.class);
    }

    @Override
    public Collection<Espectador> listarEspectadoresPorCampoIngresado(String input) {

        try {
            Query consulta = this.entityManager.createQuery("select e from Espectador as e where LOWER(e.nombre) LIKE LOWER(:input) or LOWER(e.apellido) LIKE LOWER(:input) or LOWER(e.email) LIKE LOWER(:input)");
            consulta.setParameter("input", input + "%");
            return consulta.getResultList();
        } catch (NoResultException e) {
            System.out.println("NO SE ENCONTRO LA BUSQUEDA");
            return null;
        }
    }
    
    


	@Override
	public Espectador retrieveEspectadorPorNombre(String username) {
        try {
            Query consulta = this.entityManager.createQuery("select u from Espectador as u where u.email=:email");
            consulta.setParameter("email", username);
            return (Espectador) consulta.getSingleResult();
        }
        catch (NoResultException e) {
            System.out.println(" NO HAY UN USUARIO CON ESE MAIL");
            return null;
        }
	}

    @Override
    public String existeUsuario(String email) {
        Usuario usuario;
        String correo = null;
        try {
            Query consulta = this.entityManager.createQuery("select u from Usuario as u where u.email=:email");
            consulta.setParameter("email", email);
            usuario = (Usuario) consulta.getSingleResult();
        } catch (NoResultException e) {
            usuario = null;
        }
        if (usuario != null) {
            correo = usuario.getEmail();
        }
        return correo;
    }

}