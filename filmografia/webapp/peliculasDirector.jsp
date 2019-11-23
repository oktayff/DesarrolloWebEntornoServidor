<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Peliculas por director</title>
</head>
<body>
	
	<h1 align="center">Peliculas</h1><br>
	
	<table border="1px solid black">
	<tr>
		<th>TITULO</th>
	</tr>
	
	<c:forEach items="${lista}" var="pelicula">
	  
		<tr>
	    	<td>${pelicula.titulo}</td>
		</tr>
		
	</c:forEach>
	
	</table>
	
	<a href="index.html">
		<button>Volver al menu principal</button>
	</a>
	
</body>
</html>