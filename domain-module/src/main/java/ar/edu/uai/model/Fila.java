package ar.edu.uai.model;

import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by EzequielPanoff on 31/7/15.
 */
public class Fila {

    private Long id;

    private Integer nro_fila;

    private Integer asientos_libres;

    @OneToMany (mappedBy = "fila")
    private Collection<Asiento> asientos;

    private Sector sector;

    public Fila(){}

    public Fila(Long id, Integer nro_fila) {
        this.id = id;
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

    public Integer getAsientos_libres() {
        return asientos_libres;
    }

    public void setAsientos_libres(Integer asientos_libres) {
        this.asientos_libres = asientos_libres;
    }

}
