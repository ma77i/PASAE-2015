package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.Person;
import ar.edu.uai.model.Usuario;
import ar.edu.uai.paradigms.dao.PersonDAO;
import ar.edu.uai.paradigms.dao.UsuarioDAO;
import ar.edu.uai.paradigms.service.PersonService;
import ar.edu.uai.paradigms.service.UsuarioService;

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
    public Usuario retrieveUsuario(Long identifier) {
        return this.usuarioDAO.retrieve(identifier);
    }

}
