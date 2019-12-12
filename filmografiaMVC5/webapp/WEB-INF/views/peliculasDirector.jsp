<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Peliculas por director</title>
</head>
<body>
	
	<h1 align="center">Peliculas</h1><br>
	
	<table border="1px solid black" class="table table-striped table-dark">
	<tr>
		<th>TITULO</th>
		<th>DIRECTOR</th>
	</tr>
	
	<c:forEach items="${lista}" var="pelicula">
	  
		<tr>
	    	<td>${pelicula.titulo}</td>
	    	<td>${pelicula.director}</td>
		</tr>
		
	</c:forEach>
	
	</table>
	<br>
	
	<br><a href="formDirectores.html">
		<button class="btn btn-warning">Volver a consultar</button>
	</a><br>
	
	<br><a href="index.html">
		<button class="btn btn-warning">Volver al menu principal</button>
	</a>
	
</body>
</html>