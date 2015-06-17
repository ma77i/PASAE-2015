package ar.edu.uai.paradigms.service;

public interface LoginService {

	// Devuelve un rol en base a una id de usuario proporcionada
	public String authenticate(String email,String password);
}
