<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Lista de peliculas por director</title>

</head>
<body>

	<h1 align="center">Formulario de directores</h1>
	
	<form action="peliculasDirector.html" method="POST">
		NOMBRE: <input type="text" name="director" placeholder="Introduzca el nombre">
		<input class="btn btn-warning" class="boton" type="submit" value="Consultar"><br>
	</form>
	
	<a href="index.html">
		<button type="button" class="btn btn-warning">Volver al menu principal</button>
	</a>
	
</body>
</html>