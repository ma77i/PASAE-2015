package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Sector;

import java.util.Collection;


public interface SectorService {
	public Sector saveSector(Sector sector, Long espectaculoId);

	public Sector retrieveSector(Long id_sector);

	public Collection<Sector> listarSectores();

	public boolean hayDisponibilidad(Long id_sector, Integer nro_asientos);

	public Integer cantidadAsientosDisponibles(Long id_sector);

	public Collection<Asiento> asientosDeSector(Long id_sector);

	public Collection<Asiento> asientosDisponiblesDeSector(Long id_sector);

	public Collection<Asiento> asientosOcupadosDeSector(Long id_sector);

	public void agregarSectorParaEspectaculo(Sector sector, Espectaculo espectaculo);

	public void agregarSectorParaFilas(Sector sector);

}