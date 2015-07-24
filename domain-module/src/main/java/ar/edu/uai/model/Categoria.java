package ar.edu.uai.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Matias on 30/06/2015.
 */
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre", unique = true)
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private Collection<Espectaculo> espectaculos;

    public Categoria() {

    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Espectaculo> getEspectaculos() {
        return espectaculos;
    }

    public void setEspectaculos(Collection<Espectaculo> espectaculos) {
        this.espectaculos = espectaculos;
    }
}
