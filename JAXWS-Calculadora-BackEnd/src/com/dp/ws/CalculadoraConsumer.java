package com.dp.ws;

public class CalculadoraConsumer {

	//CONSUME LOS METODOS PUBLICADOS EN EL WSDL
	
	
	public static void main(String[] args) {
		
		
		CalculadoraImplService calculadoraImplService = new CalculadoraImplService();
		ICalculadora iCalculadoraConsumer = calculadoraImplService.getCalculadoraImplPort();
		
		System.out.println("");
		System.out.println("Suma : " + iCalculadoraConsumer.operacion(1, 3, 4));
		System.out.println("");
		System.out.println("Resta : " + iCalculadoraConsumer.operacion(2, 3, 4));
		System.out.println("");
		System.out.println("Mul : " + iCalculadoraConsumer.operacion(3, 3, 4));
		System.out.println("");
		System.out.println("Div : " + iCalculadoraConsumer.operacion(4, 8, 4));
	}

}
