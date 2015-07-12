package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Espectador;


public class EspectadorDAOImplHibernateJPA extends UsuarioDAOImplHibernateJPA <Espectador> implements EspectadorDAO  {


   public  EspectadorDAOImplHibernateJPA(){
       this.setPersistentClass(Espectador.class);
   }
}
