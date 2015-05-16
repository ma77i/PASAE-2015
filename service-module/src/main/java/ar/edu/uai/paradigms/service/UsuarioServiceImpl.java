package ar.edu.uai.paradigms.service;




import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.UsuarioDAO;

import org.springframework.transaction.annotation.Transactional;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Transactional
    public Usuario saveUsuario(Usuario usuario) {
		return this.usuarioDAO.create(usuario);
		
	}

    @Override
    public Usuario retrieveUsuario(long identifier) {
       return this.usuarioDAO.retrieve(Usuario.class,identifier);
    }

}
