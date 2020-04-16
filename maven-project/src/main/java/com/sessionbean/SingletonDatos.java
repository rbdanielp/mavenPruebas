package com.sessionbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.clases.Noticia;
import com.clases.Publicacion;

@Singleton
@Startup
@LocalBean
public class SingletonDatos implements SingletonDatosLocal {

    private List<Noticia> listaNoticias;
    private List<Publicacion> listaPublicaciones;
    private int idNoticias;
    private int idPublicaciones;
    
    public SingletonDatos() {
    }
    
    @PostConstruct
    public void initialize() {
    	listaNoticias = new ArrayList<Noticia>();
    	listaPublicaciones = new ArrayList<Publicacion>();
    	idNoticias = 0;
    	idPublicaciones = 0;
    	crearNoticia("descripcionPrueba0", "tituloPrueba0");
    	crearNoticia("descripcionPrueba1", "tituloPrueba1");
    	crearNoticia("descripcionPrueba2", "tituloPrueba2");
    	crearPublicacion("prueba0", "publicacionNoticia0", 0);
    	crearPublicacion("prueba1", "publicacionNoticia0", 0);
    	crearPublicacion("prueba2", "publicacionNoticia1", 1);
    	crearPublicacion("prueba3", "publicacionNoticia1", 1);
    	crearPublicacion("prueba4", "publicacionNoticia2", 2);
    }
    
    public void crearNoticia(String descripcion, String titulo) {
    	listaNoticias.add(new Noticia(idNoticias, descripcion, titulo));
    	idNoticias++;
    }
    
    public void crearPublicacion(String tipo, String url, int idNoticia) {
    	int i = 0;
    	while(listaNoticias.get(i).getId() != idNoticia)
    		i++;
    	if(listaNoticias.get(i).getPublicacion().size() < 10) {
    		Publicacion publicacion = new Publicacion (idPublicaciones, tipo, url, listaNoticias.get(i));
        	listaNoticias.get(i).getPublicacion().add(publicacion);
        	listaPublicaciones.add(publicacion);
        	idPublicaciones++;
    	}
    }
    
    public Noticia consultarNoticia(int idNoticia) {
    	int i = 0;
    	while(i < listaNoticias.size())
    		if(listaNoticias.get(i).getId() != idNoticia)
    			return listaNoticias.get(i);
    		else
    			i++;
    	return null; 	
    }
    
    public Publicacion consultarPublicacion(int idPublicacion) {
    	int i = 0;
    	while(i < listaNoticias.size())
    		if(listaNoticias.get(i).getId() != idPublicacion)
    			return listaPublicaciones.get(i);
    		else
    			i++;
    	return null; 
    }
    
    public List<Noticia> listarNoticias(){
    	return listaNoticias;
    }
    
    public List<Publicacion> listarPublicaciones() {
    	return listaPublicaciones;
    }
    
    public List<Publicacion> listarPublicacionesNoticia(int idNoticia){
    	int i = 0;
    	while(i < listaNoticias.size())
    		if(listaNoticias.get(i).getId() == idNoticia)
    			return listaNoticias.get(i).getPublicacion();
    		else
    			i++;
    	return null;
    }
    
}
