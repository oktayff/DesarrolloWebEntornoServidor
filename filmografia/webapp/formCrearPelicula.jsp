<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar pelicula</title>
</head>
<body>
	<h1>Insertar pelicula</h1>
	
	<form action="Controller" method="POST">
		<input type="hidden" name="accion" value="insertarpeli">
		ID: <input type="text" name="id" value=""><br>
		DIRECTOR: <input type="text" name="director" value=""><br>
		TITULO: <input type="text" name="titulo" value=""><br>
		FECHA: <input type="text" name="fecha" value=""><br>
		<br><input class="boton" type="submit" value="Crear"><br>
	</form>
	
	<br><a href="mantPeliculas.jsp">
		<button>Volver</button>
	</a>
</body>
</html>