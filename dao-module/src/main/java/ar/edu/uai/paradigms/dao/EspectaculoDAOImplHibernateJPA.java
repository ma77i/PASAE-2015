package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.paradigms.ex.CustomUnexpectedEx;
import org.hibernate.HibernateException;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Date;

public class EspectaculoDAOImplHibernateJPA extends GenericDaoHibernateJPA<Espectaculo> implements EspectaculoDAO {


    public EspectaculoDAOImplHibernateJPA(){
        this.setPersistentClass(Espectaculo.class);
    }


    /**
     * Lista todos los espectaculos de un teatro
     */

    @Override
    public Long cantidadEspectaculosDeTeatro(String nombre_teatro) {

        try {
            Query consulta = this.entityManager.createQuery("select count(e) from Espectaculo as e where e.teatro.nombre=?");
            consulta.setParameter(1, nombre_teatro);
            return (Long) consulta.getSingleResult();

        }catch (HibernateException ex) {

            throw new CustomUnexpectedEx("Unexpected error " + ex.getLocalizedMessage());

        } catch (Exception ex) {
            throw new CustomUnexpectedEx("Unexpected error: " + ex.getLocalizedMessage());

        }

    }


    /**
     * Retorna si existe una funcion para un espectaculo
     */

    @Override
    public Funcion listarFuncionesDeEspectaculo(long id_funcion) {
        try {
            Query consulta = this.entityManager.createQuery("select f from Espectaculo as e join e.funciones as f where f.id=?");
            consulta.setParameter(1, id_funcion);
            return (Funcion) consulta.getSingleResult();

        }
        catch (NoResultException e) {
            System.out.println(" NO EXISTE FUNCION PARA ESE ESPECTACULO");
            return null;
        }
    }



    /**
     * Lista el nombre del espectaculo, el cual es ingresado en el input de busqueda por el usuario
     */
    @Override
    public String existeEspectaculo(String nombre_espectaculo) {
        try{
            Query consulta=this.entityManager.createQuery("select e.nombre from Espectaculo as e where e.nombre=?");
            consulta.setParameter(1,nombre_espectaculo);
            return (String)consulta.getSingleResult();
        }
        catch (NoResultException e){
            return "";
        }
    }

    /**
     * Lista todos los espectaculos que coinciden con la expresion de macheo ingresada por el usuario en el input de busqueda
     */

    @Override
    public Collection<Espectaculo> listarEspectaculosPorNombre(String nombre_espectaculo) {

            Query consulta = this.entityManager.createQuery("select e from Espectaculo as e where LOWER(e.nombre) LIKE LOWER (:nombre_espectaculo)");
            consulta.setParameter("nombre_espectaculo", "%" + nombre_espectaculo + "%");
            return consulta.getResultList();
    }


    /**
     * Lista los espectaculos entre un rango de fechas ingresadas por el usuario
     */

    @Override
    public Collection<Espectaculo> listarEspectaculosEntreRangoDeFechas(Date startDate, Date endDate) {
        Query consulta = this.entityManager.createQuery("select distinct e from Espectaculo as e join e.funciones as f where f.fecha BETWEEN :startDate AND :endDate");
        consulta.setParameter("startDate", startDate);
        consulta.setParameter("endDate", endDate);
        return consulta.getResultList();

    }

    /**
     * Lista los espectaculos segun la categoria seleccionada
     */

    @Override
    public Collection<Espectaculo> listarEspectaculosSegunCategoria(String nombre_categoria) {

        try {
            Query consulta = this.entityManager.createQuery("select e from Espectaculo as e  where e.categoria.nombre=?");
            consulta.setParameter(1, nombre_categoria);
            return consulta.getResultList();
        } catch (NoResultException e) {
            System.out.println(" NO SE ENCONTRO LA BUSQUEDA SEGUN LA CATEGORIA");
            return null;
        }
    }

    @Override
    public Long cantidadFuncionesDeEspectaculo(long idEspectaculo) {

        try {
            Query consulta = this.entityManager.createQuery("select count(f) from Espectaculo as e join e.funciones as f where e.id=?");
            consulta.setParameter(1, idEspectaculo);
            return (Long) consulta.getSingleResult();

        }catch (HibernateException ex) {

            throw new CustomUnexpectedEx("Unexpected error " + ex.getLocalizedMessage());

        } catch (Exception ex) {
            throw new CustomUnexpectedEx("Unexpected error: " + ex.getLocalizedMessage());

        }


    }

}
