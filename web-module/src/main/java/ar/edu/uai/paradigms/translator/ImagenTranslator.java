package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Imagen;
import ar.edu.uai.paradigms.dto.ImagenDTO;

/**
 * Created by EzequielPanoff on 7/8/15.
 */
public class ImagenTranslator {

    public Imagen translate(ImagenDTO imagenDTO) {

        return new Imagen(imagenDTO.getImagen());
    }

    public  ImagenDTO translateToDTO (Imagen imagen) {

        return new ImagenDTO(imagen.getImagen());
    }
}
