package ar.edu.uai.paradigms.dao;

import java.util.Collection;

import javax.persistence.Query;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Venta;


public class EspectadorDAOImplHibernateJPA extends UsuarioDAOImplHibernateJPA <Espectador> implements EspectadorDAO  {

	@Override
	public Collection<Venta> listarCompras(long identifier) {
		return null;
    //Query consulta=this.entityManager.createQuery());
	 
		
		
		
		
	}
	

}
