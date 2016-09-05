package ar.edu.uai.paradigms.service;

import java.util.ArrayList;
import java.util.Collection;

import ar.edu.uai.model.Asiento;
import ar.edu.uai.model.Fila;
import ar.edu.uai.paradigms.dao.AsientoDAO;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Matias on 31/07/2015.
 */
public class AsientoServiceImpl implements AsientoService {

    private AsientoDAO asientoDAO;

    private FilaService filaService;

    @Required
    public void setAsientoDAO(AsientoDAO asientoDAO) {
        this.asientoDAO = asientoDAO;
    }

    public void setFilaService(FilaService filaService) {
        this.filaService = filaService;
    }

    @Transactional
    public Asiento saveAsiento(Asiento asiento, Long filaId) {
        this.agregarAsientoParaFila(asiento, this.filaService.retrieveFila(filaId));
        return asientoDAO.create(asiento);
    }

    @Override
    public Asiento retrieveAsiento(long id_asiento) {
        return asientoDAO.retrieve(Asiento.class, id_asiento);
    }

    @Override
    public void agregarAsientoParaFila(Asiento asiento, Fila fila) {
        asiento.setFila(fila);
        fila.getAsientos().add(asiento);
    }

    @Override
    public Collection<Asiento> retrieveAsientos(Collection<Asiento> asientos) {
    	ArrayList<Long> identificadores = new ArrayList<Long>();
    	for (Asiento asiento : asientos) {
    		identificadores.add(asiento.getId());
		}
        return asientoDAO.retrieveCollection(Asiento.class,identificadores);
    }
    
}
