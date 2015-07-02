package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Sector;

import javax.persistence.Query;
import javax.security.sasl.SaslException;
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
		Query consulta = this.entityManager.createQuery("select a from Sector as s join s.asientos as a where s.id=?");
		consulta.setParameter(1, id_sector);
		return (Collection<Asiento>) consulta.getResultList();
	}

	public Collection<Asiento> asientosDisponiblesDeSector(long id_sector) {
		Query consulta = this.entityManager.createQuery("select a from Sector as s join s.asientos as a where a.ocupado='false' and s.id=?");
		consulta.setParameter(1, id_sector);
		return (Collection<Asiento>) consulta.getResultList();
	}

	public Collection<Asiento> asientosOcupadosDeSector(long id_sector) {
		Query consulta = this.entityManager.createQuery("select a from Sector as s join s.asientos as a where a.ocupado='true' and s.id=?");
		consulta.setParameter(1, id_sector);
		return (Collection<Asiento>) consulta.getResultList();
	}

}
