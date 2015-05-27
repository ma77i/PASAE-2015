package ar.edu.uai.paradigms.dao;

import java.util.Collection;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Venta;

/**
 * Created by Federico on 19/10/2014.
 */
public interface EspectadorDAO extends UsuarioDAO<Espectador> {
	  
	//Aca se agregan definen encabezados de metodos particulares de la entidad Espectador que luego van a ser implementados por EspectadorDAOImplHibernateJPA

	public Collection<Venta> listarCompras(long identifier);
	
}
