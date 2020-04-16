package com.servlets;

import java.io.IOException;

import javax.jms.Queue;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.negocio.Loguear;


@WebServlet("/AltaNoticia")
public class AltaNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(AltaNoticia.class);
       

    public AltaNoticia() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Loguear.logTitulo("Alta Noticia: DO GET");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Loguear.logTitulo("Alta Noticia: DO POST");
		
		logger.debug("titulo     : " + request.getParameter("titulo"));
		logger.debug("descripcion: " + request.getParameter("descripcion"));
		
		try {
			Context context = new InitialContext();
			Queue queue;
			queue = (Queue) context.lookup("");
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			
			QueueConnection queueConnection = factory.createQueueConnection();
			QueueSession queueSession = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			
			TextMessage textMessage = queueSession.createTextMessage(request.getParameter("descripcion") + "|" + request.getParameter("titulo"));
			QueueSender queueSender = queueSession.createSender(queue);
			
			queueSender.send(textMessage);
			queueConnection.close();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
