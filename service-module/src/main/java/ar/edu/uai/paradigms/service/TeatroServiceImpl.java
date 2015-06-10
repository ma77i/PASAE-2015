package ar.edu.uai.paradigms.service;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.uai.model.Teatro;
import ar.edu.uai.paradigms.dao.TeatroDAO;

public class TeatroServiceImpl implements TeatroService {
	
	private TeatroDAO teatroDAO;
	
	public TeatroDAO getTeatroDAO() {
		return teatroDAO;
	}

	public void setTeatroDAO(TeatroDAO teatroDAO) {
		this.teatroDAO = teatroDAO;
	}

	
	
	@Transactional
	public Teatro saveTeatro(Teatro teatro) {
		return teatroDAO.create (teatro);
	}

	@Override
	public Teatro retrieveTeatro(long identifier) {
		// TODO Auto-generated method stub
		return teatroDAO.retrieve(Teatro.class, identifier);
	}

}
