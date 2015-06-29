package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Transaccion;
import ar.edu.uai.paradigms.dto.TransaccionDTO;

/**
 * Created by Matias on 24/06/2015.
 */
public class TransaccionTranslator {

    public Transaccion translate(TransaccionDTO transaccionDTO) {

        return new Transaccion(transaccionDTO.getTitular(), transaccionDTO.getTitular_DNI(), transaccionDTO.getNro_tarjeta(), transaccionDTO.getCVV(), transaccionDTO.getMonto(), transaccionDTO.getResultado());
    }

    public TransaccionDTO translateToDTO(Transaccion transaccion) {
        return new TransaccionDTO(transaccion.getTitular(), transaccion.getTitular_DNI(), transaccion.getNro_tarjeta(), transaccion.getCVV(), transaccion.getMonto(), transaccion.getResultado());
    }


}
