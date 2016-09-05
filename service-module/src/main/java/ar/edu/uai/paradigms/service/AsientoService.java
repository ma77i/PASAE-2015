package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Fila;

/**
 * Created by Matias on 31/07/2015.
 */
public interface AsientoService {
	
    Asiento saveAsiento(Asiento asiento, Long filaId);

    Asiento retrieveAsiento(long id_asiento);

    void agregarAsientoParaFila(Asiento asiento, Fila fila);
    
	Collection<Asiento> retrieveAsientos(Collection<Asiento> asientos);
}
