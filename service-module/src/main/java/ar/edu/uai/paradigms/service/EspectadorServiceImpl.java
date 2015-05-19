package ar.edu.uai.paradigms.service;




import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;



public class EspectadorServiceImpl implements EspectadorService {

    private UsuarioDAO usuarioDAO;

    public EspectadorServiceImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

	@Override
	public Usuario saveEspectador(Espectador usuario) {
		return   usuarioDAO.create(usuario);
	}

	@Override
	public Usuario retrieveEspectador(long identifier) {
		return this.usuarioDAO.retrieve(Usuario.class, identifier);
	}

	
  
}
