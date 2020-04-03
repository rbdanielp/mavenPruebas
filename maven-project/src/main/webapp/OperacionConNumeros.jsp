<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Operacion con Numeros</p>
	<h1>Tratamiento de Fechas</h1>
	<form method="POST"
		action="/maven-project/Controller?accion=operacionConNumeros.do">
		
		Numero 1: <INPUT TYPE="TEXT" NAME="numero1">
		<BR>
		Numero 2: <INPUT TYPE="TEXT" NAME="numero2">
		<BR> 
		Operacion:
		<br>
		<SELECT NAME="operacion" MULTIPLE>
			<OPTION>Sumar</OPTION>
			<OPTION>Restar</OPTION>
			<OPTION>Multiplicar</OPTION>
			<OPTION>Dividir</OPTION>
		</SELECT>

		<hr>
		<center>
		<input type="submit" value="Enviar">
		</center>
	</form>
</body>
</html>