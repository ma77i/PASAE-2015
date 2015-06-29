package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.model.Transaccion;

import java.util.Collection;

/**
 * Created by Matias on 20/06/2015.
 */
public interface TarjetaService {
    Tarjeta saveTarjeta(Tarjeta tarjeta);

    Tarjeta retrieveTarjeta(long id_tarjeta);

    Collection<Tarjeta> listarTarjetas();

    Transaccion verificandoDatosTarjeta(Transaccion transaccion);

    void deleteTarjeta(long id_tarjeta);


}
