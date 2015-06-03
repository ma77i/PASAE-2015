package ar.edu.uai.paradigms.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.paradigms.dao.EspectaculoDAO;

public class EspectaculoServiceImpl implements EspectaculoService{
	
	private EspectaculoDAO espectaculoDAO;
	
	public EspectaculoServiceImpl(EspectaculoDAO espectaculoDAO) {
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
		//TODO agregar filtros
		return this.espectaculoDAO.retrieve(this.espectaculoDAO.getPersistentClass(), identifier);
	}

	@Override
	public void deleteEspectaculo(long identifier) {
		this.espectaculoDAO.delete(identifier);;
	}

	@Override
	public Collection<Espectaculo> listarEspectaculos() {
		return this.espectaculoDAO.list();
	}

	@Override
	public Espectaculo modificarEspectaculo(Espectaculo espectaculo) {
		return espectaculoDAO.update(espectaculo);	
	}

}
