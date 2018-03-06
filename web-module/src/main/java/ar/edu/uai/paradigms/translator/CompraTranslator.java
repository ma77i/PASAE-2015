package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dto.AsientoDTO;
import ar.edu.uai.paradigms.dto.CompraDTO;
import ar.edu.uai.paradigms.dto.FuncionDTO;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by EzequielPanoff on 3/9/15.
 */
public class CompraTranslator {


    public CompraDTO translateToDTO(Venta venta) {
        Collection<AsientoDTO> asientosDTO = new ArrayList<AsientoDTO>();
        for (Asiento asiento : venta.getAsientos()) {
            asientosDTO.add(new AsientoDTO(asiento.getId(), asiento.getFila().getId(), asiento.getNumero(), asiento.isOcupado()));
        }
        FuncionDTO funcionDTO= new FuncionDTO(venta.getFuncion().getId(),venta.getFuncion().getFecha(),venta.getFuncion().getHora(),venta.getFuncion().getEspectaculo().getId(), null);
        return new CompraDTO(venta.getId(), venta.getMonto(), funcionDTO, venta.getFuncion().getEspectaculo().getNombre(),asientosDTO,venta.getFechaVenta(),venta.getFechaVenta());


    }
}
