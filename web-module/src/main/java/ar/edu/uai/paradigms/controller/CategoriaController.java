package ar.edu.uai.paradigms.controller;

import ar.edu.uai.model.Categoria;
import ar.edu.uai.paradigms.dto.CategoriaDTO;
import ar.edu.uai.paradigms.service.CategoriaService;
import ar.edu.uai.paradigms.translator.CategoriaTranslator;
import ar.edu.uai.paradigms.validators.CategoriaDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Matias on 01/07/2015.
 */

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    private CategoriaTranslator categoriaTranslator;


    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);

    public CategoriaController(CategoriaService categoriaService, CategoriaTranslator categoriaTranslator) {
        this.categoriaService = categoriaService;
        this.categoriaTranslator = categoriaTranslator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new CategoriaDTOValidator());
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    CategoriaDTO createCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        LOGGER.debug("Received DTO: " + categoriaDTO);
        return this.categoriaTranslator.translateToDTO(this.categoriaService.saveCategoria(this.categoriaTranslator.translate(categoriaDTO)));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    CategoriaDTO getCategoria(@PathVariable long identifier) {
        return this.categoriaTranslator.translateToDTO(this.categoriaService.retrieveCategoria(identifier));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/listadocategorias")
    public
    @ResponseBody
    Collection<CategoriaDTO> listadoCategorias() {

        Collection<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
        Collection<Categoria> coleccion = this.categoriaService.listarCategorias();
        for (Categoria categoria : coleccion) {
            categorias.add(categoriaTranslator.translateToDTO(categoria));
        }
        return categorias;
    }

    @RequestMapping(value = "/{identifier}/modificardatos", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    CategoriaDTO modificarDatos(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        LOGGER.debug("Received DTO: " + categoriaDTO);
        return this.categoriaTranslator.translateToDTO(this.categoriaService.modificarCategoria(this.categoriaTranslator.translate(categoriaDTO)));
    }


    @RequestMapping(method = RequestMethod.POST, value = "/eliminar/{identifier}")
    @ResponseStatus(value = HttpStatus.OK)
    public void eliminarCategoria(@PathVariable long identifier) {
        this.categoriaService.deleteCategoria(identifier);
    }
}
