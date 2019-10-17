<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Salario</title>
</head>
<body>

	<% String info = (String) request.getAttribute("info"); %>
	
	<%= info %>
	
	<a href="index.html">
		<button class="boton">Volver</button>
	</a>
</body>
</html>