package ar.edu.uai.paradigms.service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Espectaculo retrieveEspectaculo(long identifier) {
		// TODO Auto-generated method stub
		return null;
	}

}
