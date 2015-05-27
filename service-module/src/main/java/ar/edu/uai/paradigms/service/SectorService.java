package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Sector;


public interface SectorService {
	public Sector saveSector(Sector sector);
	public Sector retrieveSector(long identifier);
	public Collection<Sector> listarSectores();
	

}
