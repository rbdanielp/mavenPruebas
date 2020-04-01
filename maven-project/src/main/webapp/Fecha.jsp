<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	Date dNow = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
	String currentDate = ft.format(dNow);
%>

</head>
<body>
	<p>
		La Fecha actual es:
		<%=currentDate%></p>
	<h1>Tratamiento de Fechas</h1>
	<form method="POST" action="/maven-project/Controller?accion=operacionConFecha.do">
		Horas: <INPUT TYPE="TEXT" NAME="horas"><BR>
		
		<hr>

			<input type="submit" value="Enviar">
		</center>
	</form>
</body>
</html>