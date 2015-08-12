package ar.edu.uai.paradigms.dao;


public interface UsuarioDAO<T> extends GenericDAO<T> {
 //// Puedo definir metodos comunes a los usuarios, en este caso el generic T deber�a ser un Espectador,Empleado y Administrador.
 Boolean existeUsuario(String email);

  /**
   * Retorna el tipo de usuario (rol )
   * 
   * @param email
   * @param password
   * @return
   */
  String getUserRole(String email,String password);
	
}
