package ar.edu.uai.paradigms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dao.EspectaculoDAO;
import ar.edu.uai.paradigms.dao.EspectadorDAO;
import ar.edu.uai.paradigms.dao.UsuarioDAO;


public class EspectadorService extends UsuarioService<Usuario> {
    
	

	private EspectadorDAO espectadorDAO;  

	
	

    public void setEspectadorDAO(EspectadorDAO espectadorDAO) {
		this.espectadorDAO = espectadorDAO;
	}



    public Collection<Venta> listasCompras(String usuario){
		
		return espectadorDAO.listarCompras(usuario);
		
		
	}
    
    public Collection<Espectador>listarEspectadores(){
    	return espectadorDAO.list();
    }
    
  
}
