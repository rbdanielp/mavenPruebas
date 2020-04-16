package com.sessionbean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;




@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/queue_ejercicio4"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "queue_ejercicio4")
public class AltaNoticiaMDB implements MessageListener {

	@EJB
	NoticiaPublicacionSBLocal npSessionBean;

	public AltaNoticiaMDB() {
	}

	public void onMessage(Message message) {
		String msjEntrada;
		try {
			msjEntrada = ((TextMessage) message).getText();
			String[] parts = msjEntrada.split("\\|");
			npSessionBean.crearNoticia(parts[0], parts[1]);
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
