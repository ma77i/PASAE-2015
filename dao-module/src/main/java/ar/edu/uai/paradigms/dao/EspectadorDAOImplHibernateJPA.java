package ar.edu.uai.paradigms.dao;

import java.util.Collection;

import javax.persistence.Query;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Venta;


public class EspectadorDAOImplHibernateJPA extends UsuarioDAOImplHibernateJPA <Espectador> implements EspectadorDAO  {

	@Override
	public Collection<Venta> listarCompras(String usuario) {
		
    Query consulta=this.entityManager.createQuery("from Venta as v where v.comprador=?");
    consulta.setParameter(1,usuario);
    return consulta.getResultList();
    
	}
	

}
