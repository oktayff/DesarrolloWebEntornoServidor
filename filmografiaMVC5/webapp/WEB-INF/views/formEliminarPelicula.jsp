<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Eliminar pelicula</title>
</head>
<body>
	<h1 align="center">Eliminar pelicula</h1>
	
	<form action="formEliminarPelicula.html" method="POST">
		TITULO: <input type="text" name="titulo" value=""><br>
		<br><input class="btn btn-warning" class="boton" type="submit" value="Eliminar">
	<br></form>
	
	<p>${msg }</p>
	
	<form action="mantPeliculas.html" method="POST">
		<button class="btn btn-warning">Volver</button>
	</form>
</body>
</html>