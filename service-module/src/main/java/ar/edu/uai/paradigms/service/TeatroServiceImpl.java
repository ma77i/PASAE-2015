package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Teatro;
import ar.edu.uai.paradigms.dao.TeatroDAO;

public class TeatroServiceImpl implements TeatroService {
	
	private TeatroDAO teatroDAO;
	
	@Override
	public Teatro saveTeatro(Teatro teatro) {
		return teatroDAO.create (teatro);
	}

	@Override
	public Teatro retrieveTeatro(long identifier) {
		// TODO Auto-generated method stub
		return teatroDAO.retrieve(teatroDAO.getPersistentClass(), identifier);
	}

}
