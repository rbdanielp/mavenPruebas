package com.sessionbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.clases.Noticia;
import com.clases.Publicacion;
import com.datatypes.DtNoticia;
import com.datatypes.DtPublicacion;



@Stateless
@LocalBean
@Remote(NoticiaPublicacionSBRemote.class)
public class NoticiaPublicacionSB implements NoticiaPublicacionSBRemote, NoticiaPublicacionSBLocal, java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	SingletonDatos sd;
    
    public NoticiaPublicacionSB() {
    }
    
    public void crearNoticia(String descripcion, String titulo) {
    	sd.crearNoticia(descripcion, titulo);
    }
    
    public void crearPublicacion(String tipo, String url, int idNoticia) {
    	sd.crearPublicacion(tipo, url, idNoticia);
    }
    
    public DtNoticia consultarNoticia(int idNoticia) {
    	Noticia not = sd.consultarNoticia(idNoticia);
    	return new DtNoticia(not.getId(), not.getDescipcion(), not.getTitulo(), listarDtPublicacion(not.getPublicacion()));
    }
    
    public List<DtPublicacion> listarDtPublicacion(List<Publicacion> lista){
    	List<DtPublicacion> ret = new ArrayList<DtPublicacion>(); 
    	if(lista != null)
    		for(Publicacion aux : lista) 
    			ret.add(new DtPublicacion(aux.getId(), aux.getTipo(), aux.getUrl(), aux.getNoticia().getId()));
    	return ret;
    }
    
    public DtPublicacion consultarPublicacion(int idPublicacion) {
    	Publicacion pub = sd.consultarPublicacion(idPublicacion);
    	return new DtPublicacion(pub.getId(), pub.getTipo(), pub.getUrl(), pub.getNoticia().getId());
    }
    
    public List<DtNoticia> listarNoticias(){
    	List<DtNoticia> ret = new ArrayList<DtNoticia>();
    	for(Noticia not : sd.listarNoticias()) 
    		ret.add(new DtNoticia(not.getId(), not.getDescipcion(), not.getTitulo(), listarDtPublicacion(not.getPublicacion())));
    	return ret;
    }
    
    public List<DtPublicacion> listarPublicaciones(){
    	return listarDtPublicacion(sd.listarPublicaciones());
    }
    
    public List<DtPublicacion> listarPublicacionesNoticia(int idNoticia){
    	return listarDtPublicacion(sd.listarPublicacionesNoticia(idNoticia));
    }
}
