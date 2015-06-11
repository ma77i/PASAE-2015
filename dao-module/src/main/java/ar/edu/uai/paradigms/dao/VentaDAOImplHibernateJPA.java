package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Venta;

import javax.persistence.Query;
import java.util.Collection;

public class VentaDAOImplHibernateJPA  extends GenericDaoHibernateJPA<Venta> implements VentaDAO {

	@Override
	public Collection<Venta> listarComprasDeEspectador(String espectador) {
		
		Query consulta=this.entityManager.createQuery("from Venta as v where v.comprador=?");
	    consulta.setParameter(1,espectador);
	    return consulta.getResultList();
		
	}

}
