package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Fila;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dao.FilaDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by EzequielPanoff on 31/7/15.
 */
public class FilaServiceImpl implements FilaService {

    private FilaDAO filaDAO;

    private SectorService sectorService;

    @Required
    public void setFilaDAO(FilaDAO filaDAO) {
        this.filaDAO = filaDAO;
    }

    public void setSectorService(SectorService sectorService) {
        this.sectorService = sectorService;
    }


    @Transactional
    public Fila saveFila(Fila fila, Long sectorId, Integer cantidadAsientos) {
        this.agregarFilaParaSector(fila, this.sectorService.retrieveSector(sectorId));
       // this.generarAsientosParaFila(fila, cantidadAsientos);
        return this.filaDAO.create(fila);
    }

    @Override
    public Fila retrieveFila(Long id_fila) {
        return this.filaDAO.retrieve(Fila.class, id_fila);
    }

    public void agregarFilaParaSector (Fila fila, Sector sector) {
        fila.setSector(sector);
        sector.getFilas().add(fila);
    }

   /* public void generarAsientosParaFila(Fila fila, Integer cantidad_asientos) {
        for (int i = 0; i < cantidad_asientos; i++) {
            fila.getAsientos().add(new Asiento(i));
        }
    }*/


}
