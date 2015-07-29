package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ezequiel on 28/07/2015.
 */
public class EstadoUsuarioDTO {

    private Long id;
    private Boolean estado;



    @JsonCreator
    public EstadoUsuarioDTO(@JsonProperty("id") Long id, @JsonProperty("estado") Boolean estado) {
        super();
        this.setId(id);
        this.setEstado(estado);
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public Long getId() {
        return id;
    }


}
