package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Sector;

public interface SectorDAO extends GenericDAO<Sector> {
	
	public Integer chequearDisponibilidad (String sector);

}
