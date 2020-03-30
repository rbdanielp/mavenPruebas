<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Formulario</h1>
   <form method="POST" action="/maven-project/Parametros">
     Nombre: <INPUT TYPE="TEXT" NAME="nombre"><BR>
     Primer Apellido:<INPUT TYPE="TEXT" NAME="apellido1"><BR>
     Segundo Apellido:<INPUT TYPE="TEXT" NAME="apellido2"><BR>
     <hr>
     Correo electronico: <INPUT TYPE="TEXT" NAME="email"><BR>
     Clave: <INPUT TYPE="PASSWORD" NAME="clave"><BR>
     <hr>
     Comentario: <TEXTAREA NAME="comenta" ROWS=3 COLS=40>
                 </TEXTAREA><BR>
     <hr>
     Sexo:<BR> 
	  <INPUT TYPE="RADIO" NAME="sexo" VALUE="hombre">Hombre<BR>
          <INPUT TYPE="RADIO" NAME="sexo" VALUE="mujer">Mujer<BR>

     Areas de interés:<br>
  	  <SELECT NAME="intereses" MULTIPLE>
	 	<OPTION>Informatica</OPTION>
	  	<OPTION>Derecho</OPTION>
		<OPTION>Matematicas</OPTION>
		<OPTION>Fisica</OPTION>
		<OPTION>Musica</OPTION>
	  </SELECT>

      <center><input type="submit" value="Enviar"></center>
   </form>
</body>
</html>