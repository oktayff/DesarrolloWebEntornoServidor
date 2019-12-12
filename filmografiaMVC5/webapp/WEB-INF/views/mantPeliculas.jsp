<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Mantenimiento de peliculas</title>
</head>
<body>
	
	<table border="1px solid black" class="table table-striped table-dark">
	<tr>
		<th>DIRECTOR</th>
		<th>TITULO</th>
		<th>FECHA</th>
	</tr>
	
	<c:forEach items="${pelis}" var="pelicula">
	  
		<tr>
	    	<td>${pelicula.director}</td>
	    	<td>${pelicula.titulo}</td>
	    	<td>${pelicula.fecha}</td>
		</tr>
		
	</c:forEach>
	
	</table>
	
	<h1 align="center">Elija la accion que desea realizar</h1><br>
	
	<a href="formCrearPelicula.html">
		<button class="btn btn-warning">Crear pelicula</button>
	</a><br>
	<br>
	<form action="formModificarPelicula.html" method="POST">
		Buscar pelicula: <input type="text" name="titulo" placeholder="Introduzca el titulo">
		<input class="btn btn-warning" class="boton" type="submit">
	</form>
	<br>
	<a href="formEliminarPelicula.html">
		<button class="btn btn-warning">Eliminar pelicula</button>
	</a><br>
	<br>
	<a href="index.html">
		<button class="btn btn-warning">Volver al menu principal</button>
	</a>
</body>
</html>