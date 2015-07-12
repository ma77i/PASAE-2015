package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dao.SectorDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

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

	@Required
	public void setSectorDAO(SectorDAO sectorDAO) {
		this.sectorDAO = sectorDAO;
	}

	@Transactional
	public Sector saveSector(Sector sector) {
		for (int i = 1; i <= (sector.getNro_asientos()); i++) {
			for (int x = 1; i <= ((sector.getNro_asientos()) / (sector.getNro_filas())); i++) {
				sector.getAsientos().add(new Asiento(x, i, false, sector));
			}

		}
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

	public boolean hayDisponibilidad(Long id_sector, Integer nro_asientos) {
		return (sectorDAO.chequearDisponibilidad(id_sector) > nro_asientos);
	}

	public Integer cantidadAsientosDisponibles(Long id_sector) {
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
		return (sectorDAO.asientosDisponiblesDeSector(id_sector));
	}

}
