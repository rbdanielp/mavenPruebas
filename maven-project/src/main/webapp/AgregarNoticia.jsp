<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>TSIG 2020 - Daniel Pereira</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<form action="AltaNoticia" method="POST">
		<div class="form-group">
			<label for="formGroupExampleInput">Titulo</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Titulo" name="titulo">
		    <label for="formGroupExampleInput">Descripcion</label>
		    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Descripcion" name="descripcion">
		    <button type="submit" class="btn btn-dark">Agregar</button>
		</div>
	</form>	
</body>
</html>