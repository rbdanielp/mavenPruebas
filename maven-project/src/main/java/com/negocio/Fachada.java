package com.negocio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fachada {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(Fachada.class);
	
	
	
	
	//Aqui se escriben los metodos que acceden a la DB y devulven los Beans correspondientes
	
	// Suma o resta las horas recibidos a la fecha  
	public static Date sumarRestarHorasFecha(Date fecha, int horas){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		logger.debug("Fachada: sumarRestarHorasFecha: Parametros: Fecha " + sdf.format(fecha) + " horas: " + horas );
	
	      Calendar calendar = Calendar.getInstance();
		
	      calendar.setTime(fecha); // Configuramos la fecha que se recibe
		
	      calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
		
	      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas
	}
	
	
	public static void  logTitulo(String texto){
		
		//logger.debug("logTitulo: texto " + texto );
		String linea = "";

		for (int i = 0; i < texto.length(); i++) {
			linea = linea + "=";
		}
		
		logger.debug(" ");
		logger.debug(" ");
		logger.debug(linea);
		logger.debug(texto.toUpperCase());
		logger.debug(linea);
		logger.debug(" ");
		logger.debug(" ");

	}
}
