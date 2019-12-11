<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de directores</title>
</head>
<body>
	<h1>Lista de directores consultados</h1>
	
	<table border="1px solid black">
	<tr>
		<th>NOMBRE</th>
	</tr>
	
 	<c:forEach items="${listaDirectores}" var="pelicula">
	  
		<tr>
	    	<td>${pelicula.director}</td>
		</tr>
		
	</c:forEach>
	
	</table>
	
	<a href="index.html">
		<button>Volver</button>
	</a>
</body>
</html>