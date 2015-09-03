package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by EzequielPanoff on 3/9/15.
 */
public class CompraDTO {

    private Long id;
    private Float monto;
    private FuncionDTO funcion;
    private String nombreEspectaculo;
    private Collection<AsientoDTO> asientos;

    @JsonCreator
    public CompraDTO(
            @JsonProperty("id") Long id,
            @JsonProperty("monto") Float monto,
            @JsonProperty("funcion") FuncionDTO funcion,
            @JsonProperty("nombreEspectaculo") String nombreEspectaculo,
            @JsonProperty("asientos") Collection<AsientoDTO> asientos) {
        super();
        this.setId(id);
        this.setMonto(monto);
        this.setFuncion(funcion);
        this.setNombreEspectaculo(nombreEspectaculo);
        this.setAsientos(asientos);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public FuncionDTO getFuncion() {
        return funcion;
    }

    public void setFuncion(FuncionDTO funcion) {
        this.funcion = funcion;
    }

    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }

    public void setNombreEspectaculo(String nombreEspectaculo) {
        this.nombreEspectaculo = nombreEspectaculo;
    }

    public Collection<AsientoDTO> getAsientos() {
        return asientos;
    }

    public void setAsientos(Collection<AsientoDTO> asientos) {
        this.asientos = asientos;
    }
}
