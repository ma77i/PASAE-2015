package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Sector;
import ar.edu.uai.paradigms.dto.SectorDTO;
import ar.edu.uai.paradigms.dto.SectoresDTO;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Matias on 08/08/2015.
 */
public class SectoresTranslator {
    private SectorTranslator sectorTranslator;

    public SectoresTranslator(SectorTranslator sectorTranslator) {
        this.sectorTranslator = sectorTranslator;
    }


    public Collection<Sector> translate(SectoresDTO sectoresDTO) {
        Collection<Sector> coleccion = new ArrayList<Sector>();
        Collection<SectorDTO> sectores = sectoresDTO.getSectores();
        for (SectorDTO sectorDTO : sectores) {
            coleccion.add(sectorTranslator.translate(sectorDTO));
        }

        return coleccion;
    }

}
