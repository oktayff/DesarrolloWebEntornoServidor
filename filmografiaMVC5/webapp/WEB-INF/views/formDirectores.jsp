<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de peliculas por director</title>

</head>
<body>

	<h1>Formulario de directores</h1>
	
	<form action="peliculasDirector.html" method="POST">
		NOMBRE: <input type="text" name="director" placeholder="Introduzca el nombre">
		<input class="boton" type="submit" value="Consultar"><br>
	</form>
	
	<a href="index.html">
		<button>Volver al menu principal</button>
	</a>
	
</body>
</html>