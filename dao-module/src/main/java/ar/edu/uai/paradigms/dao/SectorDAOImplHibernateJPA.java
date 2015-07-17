package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.ex.CustomQueryEx;
import ar.edu.uai.paradigms.ex.CustomResourceNotFoundEx;
import ar.edu.uai.paradigms.ex.CustomUnexpectedEx;
import org.hibernate.QueryException;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.persistence.Query;
import java.util.Collection;

public class SectorDAOImplHibernateJPA extends GenericDaoHibernateJPA<Sector> implements SectorDAO {

	public  SectorDAOImplHibernateJPA(){
       this.setPersistentClass(Sector.class);
	}


	@Override
	public Integer chequearDisponibilidad(long id_sector) {
		Query consulta = this.entityManager.createQuery("select count(a) from Sector as s join s.asientos as a where a.ocupado ='true' and s.id=?");
		consulta.setParameter(1, id_sector);
		return (Integer) consulta.getSingleResult();

	}

	@Override
	public Collection<Asiento> asientosDeSector(long id_sector) {
		try {
			Query consulta = this.entityManager.createQuery("select a from Sector as s join s.asientos as a where s.id=?");
			consulta.setParameter(1, id_sector);
			return (Collection<Asiento>) consulta.getResultList();
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

	public Collection<Asiento> asientosDisponiblesDeSector(long id_sector) {
		try {
			Query consulta = this.entityManager.createQuery("select a from Sector as s join s.asientos as a where a.ocupado='false' and s.id=?");
			consulta.setParameter(1, id_sector);
			return (Collection<Asiento>) consulta.getResultList();
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

	public Collection<Asiento> asientosOcupadosDeSector(long id_sector) {
		try {
			Query consulta = this.entityManager.createQuery("select a from Sector as s join s.asientos as a where a.ocupado='true' and s.id=?");
			consulta.setParameter(1, id_sector);
			return (Collection<Asiento>) consulta.getResultList();
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

}
