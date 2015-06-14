package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.paradigms.dao.EspectadorDAO;


public class EspectadorService extends UsuarioService<Espectador> {
    
	

	private EspectadorDAO espectadorDAO;  

	
	

    public void setEspectadorDAO(EspectadorDAO espectadorDAO) {
		this.espectadorDAO = espectadorDAO;
	}

    public Collection<Espectador>listarEspectadores(){
    	return espectadorDAO.list();
    }
    
  
}
