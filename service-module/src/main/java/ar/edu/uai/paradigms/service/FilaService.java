package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Fila;

/**
 * Created by EzequielPanoff on 31/7/15.
 */
public interface FilaService {

    public Fila saveFila(Fila fila, Long sectorId, Integer cantidadAsientos);

    public Fila retrieveFila(Long id_fila);


}
