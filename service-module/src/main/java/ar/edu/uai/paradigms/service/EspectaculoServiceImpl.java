package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.Categoria;
import ar.edu.uai.model.Espectaculo;
import ar.edu.uai.model.Funcion;
import ar.edu.uai.model.Teatro;
import ar.edu.uai.paradigms.dao.EspectaculoDAO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public class EspectaculoServiceImpl implements EspectaculoService {

	private EspectaculoDAO espectaculoDAO;

	private CategoriaService categoriaService;

	private TeatroService teatroService;

	public EspectaculoServiceImpl() {

	}

	public EspectaculoServiceImpl(EspectaculoDAO espectaculoDAO) {
		this.espectaculoDAO = espectaculoDAO;
	}

	public EspectaculoDAO getEspectaculoDAO() {
		return espectaculoDAO;
	}

	@Required
	public void setEspectaculoDAO(EspectaculoDAO espectaculoDAO) {
		this.espectaculoDAO = espectaculoDAO;
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public TeatroService getTeatroService() {
		return teatroService;
	}

	public void setTeatroService(TeatroService teatroService) {
		this.teatroService = teatroService;
	}

	@Transactional
	public Espectaculo saveEspectaculo(Espectaculo espectaculo,long categoriaId,long teatroId,MultipartFile imagen,MultipartFile imagen_portada) {
		Categoria categoria = categoriaService.retrieveCategoria(categoriaId);
		Teatro teatro = teatroService.retrieveTeatro(teatroId);
		this.agregarEspectaculoParaCategoria(espectaculo, categoria);
		this.agregarEspectaculoParaTeatro(espectaculo,teatro);
		try {
			this.agregarImagenesAlEspectaculo(espectaculo,imagen,imagen_portada);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return espectaculoDAO.update(espectaculo);
	}

	@Override
	public Espectaculo retrieveEspectaculo(long identifier) {
		// TODO agregar filtros
		return this.espectaculoDAO.retrieve(Espectaculo.class, identifier);
	}

	@Transactional
	public void deleteEspectaculo(long identifier) {
		this.espectaculoDAO.delete(identifier);
	}

	@Override
	public Collection<Espectaculo> listarEspectaculos() {
		return this.espectaculoDAO.list();
	}

	@Transactional
	public Espectaculo modificarEspectaculo(Espectaculo espectaculo, String nombre, String descripcion, long idTeatro) {

		Teatro teatro = this.teatroService.retrieveTeatro(idTeatro);
		espectaculo.setNombre(nombre);
		espectaculo.setDescripcion(descripcion);
		espectaculo.setTeatro(teatro);
		return espectaculoDAO.update(espectaculo);
	}

	@Override
	public Long cantidadEspectaculosDeTeatro(String nombre) {
		return espectaculoDAO.cantidadEspectaculosDeTeatro(nombre);
	}

	@Override
	public Funcion getFuncionDeEspectaculo(long id_funcion) {
		return espectaculoDAO.listarFuncionesDeEspectaculo(id_funcion);
	}

	@Override
	public String existeEspectaculo(String nombre_espectaculo) {
		return espectaculoDAO.existeEspectaculo(nombre_espectaculo);
	}

	@Override
	public Collection<Espectaculo> listarEspectaculosPorNombre(String nombre_espectaculo) {
		return espectaculoDAO.listarEspectaculosPorNombre(nombre_espectaculo);

	}

	@Override
	public Collection<Espectaculo> listarEspectaculosEntreFechas(Date fecha1, Date fecha2) {
		return espectaculoDAO.listarEspectaculosEntreRangoDeFechas(fecha1, fecha2);
	}

	@Override
	public Collection<Espectaculo> listarEspectaculosSegunCategoria(String nombre_categoria) {
		return espectaculoDAO.listarEspectaculosSegunCategoria(nombre_categoria);
	}

	@Override
	public void agregarEspectaculoParaCategoria(Espectaculo e,Categoria c) {
		e.setCategoria(c);
		c.getEspectaculos().add(e);
	}

	@Override
	public void agregarEspectaculoParaTeatro(Espectaculo e,Teatro t) {
		e.setTeatro(t);
		t.getEspectaculos().add(e);
	}

	@Override
	public void agregarImagenesAlEspectaculo(Espectaculo espectaculo, MultipartFile imagen, MultipartFile imagen_portada) throws IOException, SQLException {
		Blob imagenBlob= new SerialBlob(imagen.getBytes());
		Blob imagenPortadaBlob= new SerialBlob(imagen_portada.getBytes());
		espectaculo.setImagen(imagenBlob);
		espectaculo.setImagen_portada(imagenPortadaBlob);
	}

	@Override
	public Long cantidadFuncionesDeEspectaculo(long idEspectaculo) {
		return espectaculoDAO.cantidadFuncionesDeEspectaculo(idEspectaculo);
	}


}