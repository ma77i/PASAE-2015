package ar.edu.uai.paradigms.dao;

import java.util.Collection;

import javax.persistence.Query;

import ar.edu.uai.model.Venta;

public class VentaDAOImplHibernateJPA  extends GenericDaoHibernateJPA<Venta> implements VentaDAO {

	@Override
	public Collection<Venta> listarComprasDeEspectador(long id_espectador) {

		Query consulta=this.entityManager.createQuery("from Venta as v where v.comprador.id=?");
	    consulta.setParameter(1,id_espectador);
	    return consulta.getResultList();
	}

}
