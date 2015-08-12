package ar.edu.uai.paradigms.service;


import ar.edu.uai.model.Tarjeta;
import ar.edu.uai.model.Venta;
import ar.edu.uai.paradigms.dao.TarjetaDAO;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by Matias on 20/06/2015.
 */
public class TarjetaServiceImpl implements TarjetaService {

    private String serviceUrl;

    private RestTemplate restTemplate;

    private TarjetaDAO tarjetaDAO;


    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Required
    public void setTarjetaDAO(TarjetaDAO tarjetaDAO) {
        this.tarjetaDAO = tarjetaDAO;
    }

    @Override
    public Tarjeta saveTarjeta(Tarjeta tarjeta) {
        return tarjetaDAO.create(tarjeta);
    }

    @Override
    public Tarjeta retrieveTarjeta(long id_tarjeta) {
        return tarjetaDAO.retrieve(Tarjeta.class, id_tarjeta);
    }

    @Override
    public Collection<Tarjeta> listarTarjetas() {
        return tarjetaDAO.list();
    }

    @Override
    public Boolean verificandoDatosTarjeta(String numeroTarjeta, String cvv) {

        Logger LOGGER = LoggerFactory.getLogger(String.class);

        // return restTemplate
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

        //Add the Jackson Message converter
        messageConverters.add(new FormHttpMessageConverter());

        messageConverters.add(new StringHttpMessageConverter());

        messageConverters.add(new MappingJackson2HttpMessageConverter());

        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);

        Map<String, String> map = new HashMap<String, String>();
        map.put("0", "44444-44422-2222");
        map.put("1", "4444");
        
        
//        System.out.println("EL MAP :" + map.get("0") + map.get("1"));
        String mensaje = restTemplate.postForObject(serviceUrl + "concretarCompra", map, String.class);
        LOGGER.debug("El mensaje es !: " + mensaje);
        //transaccion.setResultado(mensaje);
        return true;
    }

    @Override
    public void deleteTarjeta(long id_tarjeta) {
        this.tarjetaDAO.delete(id_tarjeta);
    }


}
