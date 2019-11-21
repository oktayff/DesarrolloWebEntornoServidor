<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de directores</title>

</head>
<body>

	<h1 align="center">Formulario para consultar los directores</h1><br>
	
	<form action="PeliculasController" method="POST">
		NOMBRE: <input type="text" name="director" value="">
		<input class="boton" type="submit" value="Consultar">
	</form>
	
	<a href="index.html">
		<button>Volver</button>
	</a>
</body>
</html>