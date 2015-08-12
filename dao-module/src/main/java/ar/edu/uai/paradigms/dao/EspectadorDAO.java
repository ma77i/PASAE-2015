package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Espectador;

import java.util.Collection;

/**
 * Created by Federico on 19/10/2014.
 */
public interface EspectadorDAO extends UsuarioDAO<Espectador> {
	  
	//Aca se agregan definen encabezados de metodos particulares de la entidad Espectador que luego van a ser implementados por EspectadorDAOImplHibernateJPA

    Collection<Espectador> listarEspectadoresPorCampoIngresado(String input);

    String existeUsuario(String email);

}
