package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Funcion;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.paradigms.dao.EspectaculoDAO;

public class EspectaculoServiceImpl implements EspectaculoService {

	private EspectaculoDAO espectaculoDAO;

	public EspectaculoServiceImpl (){
		
	}
	
	public EspectaculoServiceImpl(EspectaculoDAO espectaculoDAO) {
		this.espectaculoDAO = espectaculoDAO;
	}

	public EspectaculoDAO getEspectaculoDAO() {
		return espectaculoDAO;
	}

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

	@Override
	public Espectaculo modificarEspectaculo(Espectaculo espectaculo) {
		return espectaculoDAO.update(espectaculo);
	}

	@Override
	public Collection<Espectaculo> listarEspectaculosDeTeatro(long id_teatro){
		return espectaculoDAO.listarEspectaculosDeTeatro(id_teatro);
	}

	@Override
	public Funcion getFuncionDeEspectaculo(long id_funcion) {
		return  espectaculoDAO.listarFuncionesDeEspectaculo(id_funcion);
	}


}
