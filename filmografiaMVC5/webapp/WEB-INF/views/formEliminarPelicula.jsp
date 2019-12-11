<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar pelicula</title>
</head>
<body>
	<h1>Eliminar pelicula</h1>
	
	<form action="formEliminarPelicula.html" method="POST">
		<input type="hidden" name="accion" value="eliminarpeli">
		TITULO: <input type="text" name="titulo" value=""><br>
		<br><input class="boton" type="submit" value="Eliminar"><br>
	<br></form>
	
	<p>${msg }</p>
	
	<a href="mantPeliculas.html">
		<button>Volver</button>
	</a>
</body>
</html>