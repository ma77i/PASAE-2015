package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dao.SectorDAO;

public class SectorServiceImpl implements SectorService {
    
	private SectorDAO sectorDAO;
	
	public SectorServiceImpl(SectorDAO sectorDAO) {
		this.sectorDAO = sectorDAO;
	}

	@Override
	public Sector saveSector(Sector sector) {
		return sectorDAO.create(sector);
	}

	@Override
	public Sector retrieveSector(long identifier) {
		return sectorDAO.retrieve(sectorDAO.getPersistentClass(), identifier);
	}

	@Override
	public Collection<Sector> listarSectores() {
		return sectorDAO.list();
	}

}
