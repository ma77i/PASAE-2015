package ar.edu.uai.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by EzequielPanoff on 31/7/15.
 */
@Entity
public class Fila {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer nro_fila;

    @OneToMany(mappedBy="fila", cascade={CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
    private Collection<Asiento> asientos;

    @ManyToOne
    private Sector sector;

    public Fila(){}


    public Fila(Integer nro_fila) {

        this.nro_fila = nro_fila;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNro_fila() {
        return nro_fila;
    }

    public void setNro_fila(Integer nro_fila) {
        this.nro_fila = nro_fila;
    }

    public Collection<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(Collection<Asiento> asientos) {
        this.asientos = asientos;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }


}
