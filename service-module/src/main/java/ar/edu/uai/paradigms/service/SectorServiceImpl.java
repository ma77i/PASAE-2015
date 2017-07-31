package ar.edu.uai.paradigms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dao.SectorDAO;

public class SectorServiceImpl implements SectorService {

	private SectorDAO sectorDAO;

//	private EspectaculoService espectaculoService;
	
	private FuncionService funcionService;
	
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

	public FuncionService getFuncionService() {
		return funcionService;
	}

	public void setFuncionService(FuncionService funcionService) {
		this.funcionService = funcionService;
	}

//	public void setEspectaculoService(EspectaculoService espectaculoService) {
//		this.espectaculoService = espectaculoService;
//	}

	@Transactional
	public Sector saveSector(Sector sector, Long funcionId) {
		this.agregarSectorParaFuncion(sector, this.funcionService.retrieveFuncion(funcionId));
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
	@Transactional
	public Collection<Sector> saveSectoresParaFuncion(Collection<Sector> sectores, Long idFuncion) {

		for (Sector sector : sectores) {
			this.saveSector(sector, idFuncion);
		}
		return sectores;
	}

	@Override
	public Collection<Sector> listarSectoresDeFuncion(Long idfuncion) {
		return sectorDAO.listarSectoresDeFuncion(idfuncion);
	}

	@Override
	public void agregarSectorParaFuncion(Sector sector, Funcion funcion) {
		sector.setFuncion(funcion);
		funcion.getSectores().add(sector);
	}


}
