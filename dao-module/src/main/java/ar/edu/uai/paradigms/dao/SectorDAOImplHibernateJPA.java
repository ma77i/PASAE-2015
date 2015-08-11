package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.ex.CustomQueryEx;
import ar.edu.uai.paradigms.ex.CustomUnexpectedEx;
import org.hibernate.QueryException;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Collection;

public class SectorDAOImplHibernateJPA extends GenericDaoHibernateJPA<Sector> implements SectorDAO {

	public  SectorDAOImplHibernateJPA(){
       this.setPersistentClass(Sector.class);
	}


	@Override
	public Long chequearDisponibilidad(long id_sector) {
		try {
			Query consulta = this.entityManager.createQuery("select count(a) from Sector as s join s.filas as f join f.asientos as a where a.ocupado ='false' and s.id=?");
			consulta.setParameter(1, id_sector);
			return (Long) consulta.getSingleResult();
		}
		catch (QueryException e) {
			throw new CustomQueryEx("DB error: couldn't execute query statement");
		}

		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}

	}

	@Override
	public Collection<Asiento> asientosDeSector(long id_sector) {
		Collection<Asiento> asientos;
		try {
			Query consulta = this.entityManager.createQuery("select a from Sector as s join s.filas as f join f.asientos as a where s.id=?");
			consulta.setParameter(1, id_sector);
			asientos= (Collection <Asiento>) consulta.getResultList();
		}

		catch (QueryException e) {
			throw new CustomQueryEx("DB error: couldn't execute query statement");
		}

		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}

		return asientos;
	}

	public Collection<Asiento> asientosDisponiblesDeSector(long id_sector) {
		try {
			Query consulta = this.entityManager.createQuery("select a from Sector as s join s.filas as f join f.asientos as a where a.ocupado='false' and s.id=?");
			consulta.setParameter(1, id_sector);
			return (Collection<Asiento>) consulta.getResultList();
		}
		catch (QueryException e) {
			throw new CustomQueryEx("DB error: couldn't execute query statement");
		}

		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}
	}

	public Collection<Asiento> asientosOcupadosDeSector(long id_sector) {
		Collection<Asiento> asientos;
		try {
			Query consulta = this.entityManager.createQuery("select a from Sector as s join s.filas as f join f.asientos as a where a.ocupado='true' and s.id=?");
			consulta.setParameter(1, id_sector);
			asientos= (Collection<Asiento>) consulta.getResultList();
		}

		catch (QueryException e) {
			throw new CustomQueryEx("DB error: couldn't execute query statement");
		}

		catch (Exception e) {
			throw new CustomUnexpectedEx("Unexpected error: " + e.getLocalizedMessage());
		}

		return asientos;
	}

	@Override
	public Collection<Sector> listarSectoresDeEspectaculo(Long idespectaculo) {

		try {
			Query consulta = this.entityManager.createQuery("select s from Sector as s where s.espectaculo.id=?");
			consulta.setParameter(1, idespectaculo);
			return consulta.getResultList();
		} catch (NoResultException e) {
			System.out.println(" NO HAY SECTORES ASOCIADOS AL ESPECTACULO");
			return null;
		}
	}

}
