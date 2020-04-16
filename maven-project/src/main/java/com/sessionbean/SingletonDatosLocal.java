package com.sessionbean;

import java.util.List;

import javax.ejb.Local;

import com.clases.Noticia;
import com.clases.Publicacion;

@Local
public interface SingletonDatosLocal {
	public void crearNoticia(String descripcion, String titulo);
	public void crearPublicacion(String tipo, String url, int idNoticia);
	public Noticia consultarNoticia(int idNoticia);
	public Publicacion consultarPublicacion(int idPublicacion);
	public List<Noticia> listarNoticias();
	public List<Publicacion> listarPublicaciones();
	public List<Publicacion> listarPublicacionesNoticia(int idNoticia);
}
