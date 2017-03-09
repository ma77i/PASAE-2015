package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Teatro;
import ar.edu.uai.paradigms.dao.TeatroDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class TeatroServiceImpl implements TeatroService {
	
	private TeatroDAO teatroDAO;
	
	public TeatroDAO getTeatroDAO() {
		return teatroDAO;
	}

	@Required
	public void setTeatroDAO(TeatroDAO teatroDAO) {
		this.teatroDAO = teatroDAO;
	}

	
	
	@Transactional
	public Teatro saveTeatro(Teatro teatro) {
		return teatroDAO.create (teatro);
	}

	@Override
	public Teatro retrieveTeatro(long identifier) {
		return teatroDAO.retrieve(Teatro.class, identifier);
	}

	@Override
	public Collection<Teatro> listarTeatros() {
		return teatroDAO.list();
	}

	@Transactional
	public Teatro modificarTeatro(Teatro teatro, String nombre, String direccion) {
		Teatro t= this.retrieveTeatro(teatro.getId());
		t.setNombre(nombre);
		t.setDireccion(direccion);
		return this.teatroDAO.update(t);
	}

	@Transactional
	public void deleteTeatro(long identifier) {
		this.teatroDAO.delete(identifier);
	}

}
