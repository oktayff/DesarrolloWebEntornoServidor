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
	
	<form action="Controller" method="POST">
		<input type="hidden" name="accion" value="modificarpeli">
		DIRECTOR: <input type="text" name="director" value="${pelicula.director}"> <br>
		TITULO: <input type="text" name="titulo" value="${pelicula.titulo}"> <br>
		FECHA: <input type="text" name="fecha" value="${pelicula.fecha}"> <br>
		<input class="boton" type="submit" value="Modificar">
	</form>
	<br>
	
	<br><a href="mantPeliculas.jsp">
		<button>Volver</button>
	</a>
</body>
</html>