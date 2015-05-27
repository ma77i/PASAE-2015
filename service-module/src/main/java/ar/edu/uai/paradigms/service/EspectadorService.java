package ar.edu.uai.paradigms.service;

import java.util.Collection;

import ar.edu.uai.model.Usuario;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dao.EspectaculoDAO;
import ar.edu.uai.paradigms.dao.EspectadorDAO;
import ar.edu.uai.paradigms.dao.UsuarioDAO;


public class EspectadorService extends UsuarioService<Usuario> {
    
	


	private EspectadorDAO espectadorDAO;  
	
	
	
	public Collection<Venta> listasCompras(){
		return null;
		//return espectadorDAO.listarCompras(id);
		
		
	}
  
}
