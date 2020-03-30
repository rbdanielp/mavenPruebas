package com.servlets;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;


//URL: http://localhost:8080/maven-project/invocacionPost.jsp
public class Parametros extends HttpServlet {

	private static final Logger logger = LogManager.getLogger(Parametros.class);

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info(" ");
		logger.info(" ");
		logger.info("			===================");
		logger.info("			Parametros: DO GET ");
		logger.info("			====================");
		logger.info(" ");
		logger.info(" ");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Escribimos el principio de la página HTML
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Parámetros del servlet desde un formulario HTML</h1>");

		// cogemos los nombres de los parametros
		Enumeration paramNames = request.getParameterNames();

		// vamos mostrando los parámetros en unwhile
		while (paramNames.hasMoreElements()) {
			// cogemos el siguiente parámetro
			String paramName = (String) paramNames.nextElement();

			// Mostramos el nombre del parámetro
			out.print(paramName + " = ");

			// Cogemos los valores del parámetro
			String[] paramValues = request.getParameterValues(paramName);

			// Miramos si tiene más de un valor
			if (paramValues.length == 1) {
				// Si tiene un sólo valor, miramos si está vacío o no
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<i>Sin valor</i><br>");
				else
					out.println(paramValue + "<br>");
			} else {
				// Si tiene más de un sólo valor, los mostramos
				for (int i = 0; i < paramValues.length; i++)
					out.println(paramValues[i] + ", ");
				out.println("<br>");
			}
		} // end while

		// Escribimos el final de la página HTML
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info(" ");
		logger.info(" ");
		logger.info("			===================");
		logger.info("			Parametros: DO POST");
		logger.info("			===================");
		logger.info(" ");
		logger.info(" ");
		
		doGet(request, response);
	}
}