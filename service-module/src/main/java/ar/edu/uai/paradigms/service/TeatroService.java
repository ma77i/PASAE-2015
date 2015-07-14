package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Teatro;

import java.util.Collection;

public interface TeatroService {
	
	public Teatro saveTeatro (Teatro teatro);
	public Teatro retrieveTeatro (long identifier);

	Collection<Teatro> listarTeatros();

}
