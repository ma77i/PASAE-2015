package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dto.VentaDTO;

public class VentaTranslator {

    public Venta translate(VentaDTO ventaDTO) {
        return new Venta(ventaDTO.getMonto(), ventaDTO.getCostoAdicional(),ventaDTO.getFechaVenta(),ventaDTO.getCuotas(),ventaDTO.getComprador());
    }

    public VentaDTO translateToDTO(Venta venta) {
        return new VentaDTO(venta.getMonto(),venta.getCostoAdicional(),venta.getFechaVenta(),venta.getCoutas(),venta.getComprador());
    }

}
