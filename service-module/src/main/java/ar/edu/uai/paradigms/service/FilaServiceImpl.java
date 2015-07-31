package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Fila;
import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dao.FilaDAO;

/**
 * Created by EzequielPanoff on 31/7/15.
 */
public class FilaServiceImpl implements FilaService {

    private FilaDAO filaDAO;

    private SectorService sectorService;

    @Override
    public Fila saveFila(Fila fila, Long sectorId) {
        this.agregarFilaParaSector(fila, this.sectorService.retrieveSector(sectorId));
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
}
