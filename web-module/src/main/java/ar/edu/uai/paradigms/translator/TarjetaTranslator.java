package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.paradigms.dto.TarjetaDTO;

/**
 * Created by Matias on 26/06/2015.
 */
public class TarjetaTranslator {

    public Tarjeta translate(TarjetaDTO tarjetaDTO) {

        return new Tarjeta(tarjetaDTO.getNro(), tarjetaDTO.getCvv(), tarjetaDTO.getFecha_vencimiento());
    }

    public TarjetaDTO translateToDTO(Tarjeta tarjeta) {
        return new TarjetaDTO(tarjeta.getNro_tarjeta(), tarjeta.getCvv(), tarjeta.getFecha_vencimiento());
    }


}
