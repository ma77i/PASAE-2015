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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sector retrieveSector(long identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Sector> listarSectores() {
		// TODO Auto-generated method stub
		return null;
	}

}
