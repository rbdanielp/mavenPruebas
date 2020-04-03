package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.negocio.Fachada;
import com.negocio.Loguear;

// INVOCACION 
// http://localhost:8080/maven-project/Controller?accion=123

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(Controller.class);

	// ACCIONES
	private static final String ACCION_POST = "invocacionPost.do";
	private static final String ACCION_GET = "invocacionGet.do";
	private static final String ACCION_OPERACION_CON_FECHA = "operacionConFecha.do";
	private static final String ACCION_OPERACION_CON_NUMEROS = "operacionConNumeros.do";

	
	
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Loguear.logTitulo("Controller: DO GET");

		String accion = getAccion(request);
		try {
			switch (accion) {
			case ACCION_POST:
				Loguear.logTitulo("ACCION_POST");
				break;
			case ACCION_GET:
				Loguear.logTitulo("ACCION_GET");
				break;
			case ACCION_OPERACION_CON_FECHA:

				procesar_operacion_con_fecha( request,  response);
				break;
				
			case ACCION_OPERACION_CON_NUMEROS:

				procesar_operacion_con_numeros( request,  response);
				break;

			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Loguear.logTitulo("Controller: DO POST");

		String accion = getAccion(request);
		// try {
		// switch (accion) {
		// case value:
		//
		// break;
		//
		// default:
		// break;
		// }
		// } catch (Exception e) {
		// // TODO: handle exception
		// }

		// TODO Auto-generated method stub
		doGet(request, response);
	}

	//////////////////////////////////////////////////////////////////////////////

	
	
	
	
	
	
	
	
	
	
	
	// *********************************************************************************
	// GET ACCION
	// *********************************************************************************
	private String getAccion(HttpServletRequest req) {
		// String accion = req.getRequestURI().substring(req.getContextPath().length() +
		// 1, req.getRequestURI().length());
		String accion = req.getParameter("accion");

		Loguear.logTitulo("Controller: get Accion");
		return accion;
	}

	
	// *********************************************************************************
	//
	// *********************************************************************************
	private void procesar_operacion_con_fecha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Loguear.logTitulo("procesar_operacion_con_fecha");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		int horas = 0;
		horas = Integer.parseInt(request.getParameter("horas"));

		Date dNow = new Date();
		String fechaActual = sdf.format(dNow);
		logger.debug("fechaActual: " + fechaActual);

		logger.debug("horas: " + horas);
		Date nuevaF = Fachada.sumarRestarHorasFecha(dNow, horas);

		String nuevaFecha = sdf.format(nuevaF);
		logger.debug("nuevaFecha: " + nuevaFecha);

		escibirFechaRespuesta(response, nuevaFecha);
	}
	
	// *********************************************************************************
	//
	// *********************************************************************************
	private void procesar_operacion_con_numeros(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Loguear.logTitulo("procesar_operacion_con_numeros");
		
	

		int numeroFinal = 0;
		int numero1 = 0;
		int numero2 = 0;
		
		String operacion = request.getParameter("operacion");
		logger.debug("operacion: " + operacion);
		numero1 = Integer.parseInt(request.getParameter("numero1"));
		logger.debug("numero1: " + numero1);
		numero2 = Integer.parseInt(request.getParameter("numero2"));
		logger.debug("numero2: " + numero2);



		numeroFinal = Fachada.procesarOperacionConDosNumeros(operacion, numero1, numero2);


		logger.debug("numeroFinal: " + numeroFinal);

		escibirNumeroRespuesta(response, numeroFinal);
	}
	
	// *********************************************************************************
	//
	// *********************************************************************************
	private Enumeration getParametrosOperacionesFecha(HttpServletRequest req) {
		Enumeration paramOperacionesFecha = req.getParameterNames();

		Loguear.logTitulo("Controller: getParametrosOperacionesFecha");
		return paramOperacionesFecha;
	}

	
	
	// *********************************************************************************
	//
	// *********************************************************************************
	private void escibirFechaRespuesta(HttpServletResponse response, String nuevaFecha) throws IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Resultado</h1><br>");
		out.println("<br>");

		out.print("Nueva Fecha: " + nuevaFecha);

		out.println("<br>");
		out.println("<br>");
		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
	}
	
	// *********************************************************************************
	//
	// *********************************************************************************
	private void escibirNumeroRespuesta(HttpServletResponse response, int numero) throws IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Resultado</h1><br>");
		out.println("<br>");

		out.print("Resultado: " + numero);

		out.println("<br>");
		out.println("<br>");
		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
	}

}
