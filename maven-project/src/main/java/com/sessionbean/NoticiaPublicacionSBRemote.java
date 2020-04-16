package com.sessionbean;

import java.util.List;

import javax.ejb.Remote;

import com.clases.Publicacion;
import com.datatypes.DtNoticia;
import com.datatypes.DtPublicacion;

@Remote
public interface NoticiaPublicacionSBRemote {
	 public void crearNoticia(String descripcion, String titulo);
	 public void crearPublicacion(String tipo, String url, int idNoticia);
	 public DtNoticia consultarNoticia(int idNoticia);
	 public List<DtPublicacion> listarDtPublicacion(List<Publicacion> lista);
	 public DtPublicacion consultarPublicacion(int idPublicacion);
	 public List<DtNoticia> listarNoticias();
	 public List<DtPublicacion> listarPublicaciones();
	 public List<DtPublicacion> listarPublicacionesNoticia(int idNoticia);
}
