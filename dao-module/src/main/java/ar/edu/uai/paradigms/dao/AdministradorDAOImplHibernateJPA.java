package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Administrador;



public class AdministradorDAOImplHibernateJPA extends UsuarioDAOImplHibernateJPA <Administrador> implements AdministradorDAO {


    public AdministradorDAOImplHibernateJPA(){
       this.setPersistentClass(Administrador.class);
    }


}
