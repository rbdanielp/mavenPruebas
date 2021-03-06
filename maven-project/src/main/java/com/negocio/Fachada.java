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
	public static Date sumarRestarHorasFecha(Date fecha, int horas) {
		Loguear.logTitulo("sumarRestarHorasFecha");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		logger.debug("Fachada: sumarRestarHorasFecha: Parametros: Fecha " + sdf.format(fecha) + " horas: " + horas);

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(fecha); // Configuramos la fecha que se recibe

		calendar.add(Calendar.HOUR, horas); // numero de horas a añadir, o restar en caso de horas<0

		return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas
	}
	
	
	
	public static int procesarOperacionConDosNumeros(String operacion, int numero1, int numero2) {
		Loguear.logTitulo("procesarOperacionConDosNumeros");
		
		int numeroFinal = 0;

		switch (operacion) {
		case "Sumar":
			numeroFinal = numero1 + numero2;
			break;
		case "Restar":
			numeroFinal = numero1 - numero2;
			break;
		case "Multiplicar":
			numeroFinal = numero1 * numero2;
			break;
		case "Dividir":
			numeroFinal = 0;
			break;
 
		default:
			numeroFinal = 0;
			break;
		}
		return numeroFinal;
	}
	
}
