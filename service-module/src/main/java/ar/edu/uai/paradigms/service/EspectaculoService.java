package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Espectaculo;


public interface EspectaculoService {
	public Espectaculo saveEspectaculo(Espectaculo espectaculo);
	public Espectaculo retrieveEspectaculo(long identifier);

}
