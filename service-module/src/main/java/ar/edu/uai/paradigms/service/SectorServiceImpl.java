package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dao.SectorDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class SectorServiceImpl implements SectorService {

	private SectorDAO sectorDAO;

	private EspectaculoService espectaculoService;
	
	public SectorServiceImpl (){
		
	}

	public SectorServiceImpl(SectorDAO sectorDAO) {
		this.sectorDAO = sectorDAO;
	}

	public SectorDAO getSectorDAO() {
		return sectorDAO;
	}

	@Required
	public void setSectorDAO(SectorDAO sectorDAO) {
		this.sectorDAO = sectorDAO;
	}

	public void setEspectaculoService(EspectaculoService espectaculoService) {
		this.espectaculoService = espectaculoService;
	}

	@Transactional
	public Sector saveSector(Sector sector, Long espectaculoId) {
		this.agregarSectorParaEspectaculo(sector, this.espectaculoService.retrieveEspectaculo(espectaculoId));
		return sectorDAO.create(sector);
	}

	@Override
	public Sector retrieveSector(Long id_sector) {
		return sectorDAO.retrieve(Sector.class, id_sector);
	}

	@Override
	public Collection<Sector> listarSectores() {
		return sectorDAO.list();
	}

	public Boolean hayDisponibilidad(Long id_sector, Integer nro_asientos) {
		return (this.cantidadAsientosDisponibles(id_sector) > nro_asientos);
	}

	public Long cantidadAsientosDisponibles(Long id_sector) {
		return (sectorDAO.chequearDisponibilidad(id_sector));
	}

	@Override
	public Collection<Asiento> asientosDeSector(Long id_sector) {
		return (sectorDAO.asientosDeSector (id_sector));
	}


	@Override
	public Collection<Asiento> asientosDisponiblesDeSector(Long id_sector) {
		return (sectorDAO.asientosDisponiblesDeSector(id_sector));
	}


	@Override
	public Collection<Asiento> asientosOcupadosDeSector(Long id_sector) {
		return (sectorDAO.asientosOcupadosDeSector(id_sector));
	}

	@Override
	public void agregarSectorParaEspectaculo(Sector sector, Espectaculo espectaculo) {
		sector.setEspectaculo(espectaculo);
		espectaculo.getSectores().add(sector);
	}

	@Override
	@Transactional
	public Collection<Sector> saveSectoresParaEspectaculo(Collection<Sector> sectores, Long idEspectaculo) {

		for (Sector sector : sectores) {
			this.saveSector(sector, idEspectaculo);
		}
		return sectores;
	}


}
