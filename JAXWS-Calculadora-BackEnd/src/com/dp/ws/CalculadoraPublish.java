package com.dp.ws;

import javax.xml.ws.Endpoint;

public class CalculadoraPublish {

	//CREA EL WSDL; QUE ES EL CONTRATO DONDE SE EXPONEN LOS SERVICIOS CREADOS
	
	
	public static void main(String[] args) {
		String address     = "http://localhost:8080/WS/ICalculadora";
		String implementor = "CalculadoraImpl";
		Endpoint.publish(address, new CalculadoraImpl());


	}

}
