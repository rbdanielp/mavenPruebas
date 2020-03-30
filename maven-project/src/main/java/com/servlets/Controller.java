package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// INVOCACION 
// http://localhost:8080/maven-project/Controller?accion=123


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(Controller.class);
	private static final String ACCION_POST= "invocacionPost.do";
	private static final String ACCION_GET= "invocacionGet.do";

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
		logger.debug(" ");
		logger.debug(" ");
		logger.debug("			===================");
		logger.debug("			Controller: DO GET ");
		logger.debug("			===================");
		logger.debug(" ");
		logger.debug(" ");

		String accion = getAccion(request);
		try {
			switch (accion) {
			case ACCION_POST:
				logger.debug("Controller: switch: invocacionPost.do");
				break;
			case ACCION_GET:
				logger.debug("Controller: switch: invocacionGet.do");
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
		logger.debug(" ");
		logger.debug(" ");
		logger.debug("			===================");
		logger.debug("			Controller: DO POST");
		logger.debug("			===================");
		logger.debug(" ");
		logger.debug(" ");
		
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
		
		logger.debug(" ");
		logger.debug("Controller: Accion: " + accion);
		logger.debug(" ");
		return accion;
	}

}
