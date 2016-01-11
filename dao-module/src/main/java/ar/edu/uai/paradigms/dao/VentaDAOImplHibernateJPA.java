package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.ex.CustomQueryEx;
import ar.edu.uai.paradigms.ex.CustomResourceNotFoundEx;
import ar.edu.uai.paradigms.ex.CustomUnexpectedEx;
import org.hibernate.QueryException;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class VentaDAOImplHibernateJPA  extends GenericDaoHibernateJPA<Venta> implements VentaDAO {


	public VentaDAOImplHibernateJPA(){

		this.setPersistentClass(Venta.class);
	}

	/**
	 * Lista las compras de un espectador
	 */

	@Override
	public Collection<Venta> listarComprasDeEspectador(String username) {
		try {
			Query consulta = this.entityManager.createQuery("from Venta as v  where v.comprador.email=?");
			consulta.setParameter(1, username);
			return consulta.getResultList();
		}
		catch (EmptyResultDataAccessException e) {
			throw new CustomResourceNotFoundEx("Resource not found (empty set value)");
		}

		catch (QueryException e) {
			throw new CustomQueryEx("DB error: couldn't execute query statement");
		}

		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}
	}
    @Override
	public Float calcularMontoNeto(long id_sector, long id_espectaculo) {

		try {
			Query consulta = this.entityManager.createQuery("select s.monto from Sector where s.id=? and s.espectaculo.id=?");
			consulta.setParameter(1, id_sector);
			consulta.setParameter(2, id_espectaculo);
			return (Float) consulta.getSingleResult();
		}
		catch (NoResultException e) {
			throw new CustomResourceNotFoundEx("Query result is empty");
		}

		catch (NonUniqueResultException e) {
			throw new CustomQueryEx("Query result is not unique");

		}

		catch (QueryException e) {
			throw new CustomQueryEx("DB error: couldn't execute query statement");
		}

		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}
	}

	@Override
	public List<Object[]> listarCantidadVentasPorMes() {
		Query consulta = this.entityManager.createQuery("SELECT month(v.fechaVenta),count (v) from Venta v group by month(v.fechaVenta)");
		return consulta.getResultList();
	}

	@Override
	public List<Object[]> listasdEspectaculosVendidos() {
		Query consulta = this.entityManager.createQuery("SELECT v.funcion.espectaculo.nombre,sum (v.monto) from Venta v group by v.funcion.espectaculo.nombre ");
		return consulta.getResultList();
	}


}
