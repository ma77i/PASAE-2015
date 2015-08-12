package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.model.Venta;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Matias on 20/06/2015.
 */
public interface TarjetaService {
    Tarjeta saveTarjeta(Tarjeta tarjeta);

    Tarjeta retrieveTarjeta(long id_tarjeta);

    Collection<Tarjeta> listarTarjetas();

    Boolean verificandoDatosTarjeta(String numeroTarjeta , String cvv);

    void deleteTarjeta(long id_tarjeta);

	Tarjeta retrieveTarjetaByNumero(String numeroTarjeta, Integer cvv, Date date);


}
