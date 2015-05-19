package ar.edu.uai.paradigms.service;
import ar.edu.uai.model.Espectador;
import ar.edu.uai.model.Usuario;


public interface EspectadorService {

	public Usuario saveEspectador(Espectador usuario);

   public Usuario retrieveEspectador(long identifier);


}
