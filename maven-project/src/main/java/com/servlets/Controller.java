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
		logger.info(" ");
		logger.info(" ");
		logger.info("			=======");
		logger.info("			DO GET ");
		logger.info("			=======");
		logger.info(" ");
		logger.info(" ");

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info(" ");
		logger.info(" ");
		logger.info("			=======");
		logger.info("			DO POST");
		logger.info("			=======");
		logger.info(" ");
		logger.info(" ");
		
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
		
		logger.info(" ");
		logger.info("Accion: " + accion);
		logger.info(" ");
		return accion;
	}

}
