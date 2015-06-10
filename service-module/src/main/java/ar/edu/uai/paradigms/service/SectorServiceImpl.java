package ar.edu.uai.paradigms.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dao.SectorDAO;

public class SectorServiceImpl implements SectorService {

	private SectorDAO sectorDAO;
	
	public SectorServiceImpl (){
		
	}

	public SectorServiceImpl(SectorDAO sectorDAO) {
		this.sectorDAO = sectorDAO;
	}

	public SectorDAO getSectorDAO() {
		return sectorDAO;
	}

	public void setSectorDAO(SectorDAO sectorDAO) {
		this.sectorDAO = sectorDAO;
	}

	@Transactional
	public Sector saveSector(Sector sector) {
		return sectorDAO.create(sector);
	}

	@Override
	public Sector retrieveSector(long identifier) {
		return sectorDAO.retrieve(Sector.class, identifier);
	}

	@Override
	public Collection<Sector> listarSectores() {
		return sectorDAO.list();
	}

}
