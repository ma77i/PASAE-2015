package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.paradigms.dao.EspectadorDAO;
import org.springframework.beans.factory.annotation.Required;


public class EspectadorService extends UsuarioService<Espectador> {
    
	

	private EspectadorDAO espectadorDAO;  

	
	

	@Required
    public void setEspectadorDAO(EspectadorDAO espectadorDAO) {
		this.espectadorDAO = espectadorDAO;
	}

    public Collection<Espectador>listarEspectadores(){
         System.out.println(espectadorDAO.getPersistentClass().getName());

		return espectadorDAO.list();
	}
    
  
}
