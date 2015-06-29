package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.dao.EspectaculoDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

public class EspectaculoServiceImpl implements EspectaculoService {

	private EspectaculoDAO espectaculoDAO;

	public EspectaculoServiceImpl() {

	}

	public EspectaculoServiceImpl(EspectaculoDAO espectaculoDAO) {
		this.espectaculoDAO = espectaculoDAO;
	}

	public EspectaculoDAO getEspectaculoDAO() {
		return espectaculoDAO;
	}

	@Required
	public void setEspectaculoDAO(EspectaculoDAO espectaculoDAO) {
		this.espectaculoDAO = espectaculoDAO;
	}

	@Transactional
	public Espectaculo saveEspectaculo(Espectaculo espectaculo) {
		// Quizá debería tener un create en caso de existir ( consultar )
		this.espectaculoDAO.update(espectaculo);
		return espectaculo;
	}

	@Override
	public Espectaculo retrieveEspectaculo(long identifier) {
		// TODO agregar filtros
		return this.espectaculoDAO.retrieve(Espectaculo.class, identifier);
	}

	@Override
	public void deleteEspectaculo(long identifier) {
		this.espectaculoDAO.delete(identifier);
	}

	@Override
	public Collection<Espectaculo> listarEspectaculos() {
		return this.espectaculoDAO.list();
	}

	@Transactional
	public Espectaculo modificarEspectaculo(Espectaculo espectaculo) {
		Espectaculo e = this.retrieveEspectaculo(espectaculo.getId());
		e.setNombre(espectaculo.getNombre());
		e.setDescripcion(espectaculo.getDescripcion());
		return espectaculoDAO.update(e);
	}

	@Override
	public Collection<Espectaculo> listarEspectaculosDeTeatro(long id_teatro) {
		return espectaculoDAO.listarEspectaculosDeTeatro(id_teatro);
	}

	@Override
	public Funcion getFuncionDeEspectaculo(long id_funcion) {
		return espectaculoDAO.listarFuncionesDeEspectaculo(id_funcion);
	}

	@Override
	public String existeEspectaculo(String nombre_espectaculo) {
		return espectaculoDAO.existeEspectaculo(nombre_espectaculo);
	}

	@Override
	public Collection<Espectaculo> listarEspectaculosPorNombre(String nombre_espectaculo) {
		return espectaculoDAO.listarEspectaculosPorNombre(nombre_espectaculo);

	}

	@Override
	public Collection<Espectaculo> listarEspectaculosEntreFechas(Date fecha1, Date fecha2) {
		return espectaculoDAO.listarEspectaculosEntreRangoDeFechas(fecha1, fecha2);
	}
}