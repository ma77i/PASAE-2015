package ar.edu.uai.paradigms.dao;

import java.util.Date;

import ar.edu.uai.model.Tarjeta;

/**
 * Created by Matias on 22/06/2015.
 */
public interface TarjetaDAO extends GenericDAO<Tarjeta> {

	Tarjeta retrieveTarjetaByNumero(String numeroTarjeta, Integer cvv, Date date);
}
