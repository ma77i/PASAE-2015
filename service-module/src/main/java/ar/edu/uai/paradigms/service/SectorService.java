package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Sector;

import java.util.Collection;


public interface SectorService {
	public Sector saveSector(Sector sector);

	public Sector retrieveSector(long id_sector);

	public Collection<Sector> listarSectores();

	public boolean hayDisponibilidad(long id_sector, Integer nro_asientos);

	public Integer cantidadAsientosDisponibles (long id_sector );

	public Collection<Asiento> asientosDeSector (long id_sector);

	public Collection <Asiento> asientosDisponiblesDeSector (long id_sector);

	public Collection <Asiento> asientosOcupadosDeSector (long id_sector);


}