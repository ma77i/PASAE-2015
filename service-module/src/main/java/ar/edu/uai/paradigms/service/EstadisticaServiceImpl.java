package ar.edu.uai.paradigms.service;

import ar.edu.uai.paradigms.dao.VentaDAO;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * Created by Matias on 03/10/2015.
 */
public class EstadisticaServiceImpl implements  EstadisticaService {

    private VentaDAO ventaDAO;


    @Required
    public void setVentaDAO(VentaDAO ventaDAO) {
        this.ventaDAO = ventaDAO;
    }


    @Override
    public List<Object[]> listarVentas() {
        return ventaDAO.listarCantidadVentasPorMes();
    }

    @Override
    public List<Object[]> ventasRealizadasDeEspectaculos() {
        return ventaDAO.listasdEspectaculosVendidos();
    }


}
