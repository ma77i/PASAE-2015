package ar.edu.uai.paradigms.dao;


import ar.edu.uai.model.Usuario;

public interface UsuarioDAO<T> extends GenericDAO<T> {
 //// Puedo definir metodos comunes a los usuarios, en este caso el generic T deber�a ser un Espectador,Empleado y Administrador.
  Usuario existeUsuario(String nombre_usuario);

  /**
   * Retorna el tipo de usuario (rol )
   * 
   * @param email
   * @param password
   * @return
   */
  String getUserRole(String email,String password);
	
}
