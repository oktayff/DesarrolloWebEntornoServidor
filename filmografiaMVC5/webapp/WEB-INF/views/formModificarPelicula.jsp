<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar pelicula</title>
</head>
<body>
	<h1>Modificar pelicula</h1>
	
	<form action="actualizacionPeli.html" method="POST">
		DIRECTOR: <input type="text" name="director" value="${pelicula.director}"> <br>
		TITULO: <input type="text" name="titulo" value="${pelicula.titulo}"> <br>
		FECHA: <input type="text" name="fecha" value="${pelicula.fecha}"> <br>
		<input class="boton" type="submit" value="Modificar">
	</form>
	<br>
	
	<p>${msg }</p>
	
	<br><a href="mantPeliculas.html">
		<button>Volver</button>
	</a>
</body>
</html>