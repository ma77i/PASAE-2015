package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.paradigms.dao.EspectadorDAO;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collection;


public class EspectadorService extends UsuarioService<Espectador> {
    
	

	private EspectadorDAO espectadorDAO;  

	
	@Required
    public void setEspectadorDAO(EspectadorDAO espectadorDAO) {
		this.espectadorDAO = espectadorDAO;
	}

    public Collection<Espectador>listarEspectadores(){
		return espectadorDAO.list();
	}

	public Collection<Espectador> listarEspectadoresPorCampoIngresado(String input) {
		return espectadorDAO.listarEspectadoresPorCampoIngresado(input);

	}

	public Espectador retrieveEspectadorPorNombre(String username){
		return this.espectadorDAO.retrieveEspectadorPorNombre(username);
	}

}
