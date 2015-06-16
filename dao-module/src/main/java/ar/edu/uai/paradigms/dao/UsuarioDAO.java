package ar.edu.uai.paradigms.dao;


import ar.edu.uai.model.Usuario;

public interface UsuarioDAO<T> extends GenericDAO<T> {
 //// Puedo definir metodos comunes a los usuarios, en este caso el generic T deber�a ser un Espectador,Empleado y Administrador.
  Usuario existeUsuario(String nombre_usuario);

  String getUserRole(long id,String password);
	
}
