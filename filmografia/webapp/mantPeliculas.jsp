<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mantenimiento de peliculas</title>
</head>
<body>
	<h1> Mantenimiento </h1>
	
	<table border="1px solid black">
	<tr>
		<th>ID</th>
		<th>DIRECTOR</th>
		<th>TITULO</th>
		<th>FECHA</th>
	</tr>
	
	<c:forEach items="${pelis}" var="pelicula">
	  
		<tr>
	    	<td>${pelicula.id}</td>
	    	<td>${pelicula.director}</td>
	    	<td>${pelicula.titulo}</td>
	    	<td>${pelicula.fecha}</td>
		</tr>
		
	</c:forEach>
	
	</table>
	
	<h1>Elija la accion que desea realizar</h1><br>
	
	<a href="formCrearPelicula.jsp">
		<button>Crear pelicula</button>
	</a><br>
	<br>
	<form action="Controller" method="POST">
		<input type="hidden" name="accion" value="buscarpeli">
		Buscar pelicula: <input type="text" name="id" placeholder="Introduzca el titulo">
		<input class="boton" type="submit">
	</form><br>
	<br>
	<a href="formEliminarPelicula.jsp">
		<button>Eliminar pelicula</button>
	</a><br>
	<br>
	<a href="index.html">
		<button>Volver al menu principal</button>
	</a>
</body>
</html>