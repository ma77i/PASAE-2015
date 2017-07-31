package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Sector;


public interface SectorService {
	public Sector saveSector(Sector sector, Long funcionId);

	public Sector retrieveSector(Long id_sector);

	public Collection<Sector> listarSectores();

	public Boolean hayDisponibilidad(Long id_sector, Integer nro_asientos);

	public Long cantidadAsientosDisponibles(Long id_sector);

	public Collection<Asiento> asientosDeSector(Long id_sector);

	public Collection<Asiento> asientosDisponiblesDeSector(Long id_sector);

	public Collection<Asiento> asientosOcupadosDeSector(Long id_sector);

	public void agregarSectorParaFuncion(Sector sector, Funcion funcion);

	public Collection<Sector> saveSectoresParaFuncion(Collection<Sector> sectores, Long idFuncion);

	Collection<Sector> listarSectoresDeFuncion(Long idfuncion);
}