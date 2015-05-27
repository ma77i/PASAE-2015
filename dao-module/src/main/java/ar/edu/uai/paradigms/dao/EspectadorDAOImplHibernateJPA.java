package ar.edu.uai.paradigms.dao;

import java.util.Collection;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Venta;


public class EspectadorDAOImplHibernateJPA extends UsuarioDAOImplHibernateJPA <Espectador> implements EspectadorDAO  {

	@Override
	public Collection<Venta> listarCompras(long identifier) {
		return null;
		
		
	}
	

}
