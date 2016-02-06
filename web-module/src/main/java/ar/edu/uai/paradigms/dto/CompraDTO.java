package ar.edu.uai.paradigms.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;

/**
 * Created by EzequielPanoff on 3/9/15.
 */
public class CompraDTO {

    private Long id;
    private Long monto;
    private FuncionDTO funcion;
    private String nombreEspectaculo;
    private Collection<AsientoDTO> asientos;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date hora;

    @JsonCreator
    public CompraDTO(
            @JsonProperty("id") Long id,
            @JsonProperty("monto") Long monto,
            @JsonProperty("funcion") FuncionDTO funcion,
            @JsonProperty("nombreEspectaculo") String nombreEspectaculo,
            @JsonProperty("asientos") Collection<AsientoDTO> asientos,
            @JsonProperty("fecha")Date fecha,
            @JsonProperty("hora")Date hora) {
        super();
        this.setId(id);
        this.setMonto(monto);
        this.setFuncion(funcion);
        this.setNombreEspectaculo(nombreEspectaculo);
        this.setAsientos(asientos);
        this.setFecha(fecha);
        this.setHora(hora);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
}
