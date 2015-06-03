package ar.edu.uai.paradigms.dao;

import javax.persistence.Query;

import ar.edu.uai.model.Sector;

public class SectorDAOImplHibernateJPA extends GenericDaoHibernateJPA<Sector>
		implements SectorDAO {

	@Override
	public Long chequearDisponibilidad(String sector) {
		Query consulta = this.entityManager
				.createQuery("select count(a) from Sector as s join s.asientos as a where a.ocupado ='true' and s.nombre=?");
		consulta.setParameter(1, sector);
		return (Long) consulta.getSingleResult();
		//prueba

	}
}
