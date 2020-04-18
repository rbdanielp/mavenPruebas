package com.dp.ws;

import javax.jws.WebService;

@WebService(endpointInterface="com.dp.ws.ICalculadora")
public class CalculadoraImpl implements ICalculadora{

	//IMPLEMENTA LOS METODOS DEFINIDOS EN  LA INTERFAZ
	
	
	@Override
	public double operacion(int opcion, int valor1, int valor2) {
		double resultado =0;
		
		
		switch (opcion) {
		case 1:
			resultado = valor1+valor2;
			break;
		case 2:
			resultado = valor1-valor2;
			break;
		case 3:
			resultado = valor1*valor2;
			break;
		case 4:
			resultado = valor1/valor2;
			break;

		default:
			resultado =0;
			break;
		}
		return resultado;
	}

}
