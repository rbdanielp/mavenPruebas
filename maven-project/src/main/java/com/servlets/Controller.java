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

// INVOCACION 
// http://localhost:8080/maven-project/Controller?accion=123


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(Controller.class);
	private static final String ACCION_POST= "invocacionPost.do";
	private static final String ACCION_GET= "invocacionGet.do";
	private static final String ACCION_OPERACION_CON_FECHA= "operacionConFecha.do";

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Fachada.logTitulo("Controller: DO GET");
		

		String accion = getAccion(request);
		try {
			switch (accion) {
			case ACCION_POST:
				//logger.debug("Controller: switch: ACCION_POST");
				Fachada.logTitulo("ACCION_POST");
				break;
			case ACCION_GET:
				//logger.debug("Controller: switch: ACCION_GET");
				Fachada.logTitulo("ACCION_GET");
			break;	
			case ACCION_OPERACION_CON_FECHA:
				//logger.debug("Controller: switch: ACCION_OPERACION_CON_FECHA");
				Fachada.logTitulo("ACCION_OPERACION_CON_FECHA");
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				int horas = 0;
				horas = Integer.parseInt(request.getParameter("horas"));
				
				Date dNow = new Date();
				String fechaActual = sdf.format(dNow);
				logger.debug("fechaActual: " + fechaActual );
				
				logger.debug("horas: " + horas );
				Date nuevaF = Fachada.sumarRestarHorasFecha(dNow, horas);
			
				String nuevaFecha = sdf.format(nuevaF);
				logger.debug("nuevaFecha: " + nuevaFecha );
				
				escibirFechaRespuesta(response,  nuevaFecha);

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Fachada.logTitulo("Controller: DO POST");
		
		String accion = getAccion(request);
//		try {
//			switch (accion) {
//			case value:
//				
//				break;
//
//			default:
//				break;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	//////////////////////////////////////////////////////////////////////////////

	// *********************************************************************************
	// GET ACCION
	// *********************************************************************************
	private String getAccion(HttpServletRequest req) {
		//String accion = req.getRequestURI().substring(req.getContextPath().length() + 1, req.getRequestURI().length());
		String accion = req.getParameter("accion");
		
		Fachada.logTitulo("Controller: get Accion");
		return accion;
	}
	
	
	// *********************************************************************************
	// 
	// *********************************************************************************
	private Enumeration getParametrosOperacionesFecha(HttpServletRequest req) {
		Enumeration paramOperacionesFecha = req.getParameterNames();
		
		Fachada.logTitulo("Controller: getParametrosOperacionesFecha");
		return paramOperacionesFecha;
	}
	
	
	// *********************************************************************************
	// 
	// *********************************************************************************
	private void  escibirFechaRespuesta(HttpServletResponse response, String nuevaFecha) throws IOException {
		
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

}
