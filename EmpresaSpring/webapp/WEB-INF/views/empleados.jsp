<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empleados</title>

</head>
<body>
	
	<h1 align="center">Empleados</h1><br>
	
	<table border="1px solid black">
	<tr>
		<th>NOMBRE</th>
		<th>DNI</th>
		<th>SEXO</th>
		<th>CATEGORIA</th>
		<th>ANYOS</th>
	</tr>
	
	<c:forEach items="${lista}" var="empleado">
	  
		<tr>
	    	<td>${empleado.nombre}</td>
	    	<td>${empleado.dni}</td>
	    	<td>${empleado.sexo}</td>
	    	<td>${empleado.categoria}</td>
	    	<td>${empleado.anyos}</td>
		</tr>
		
	</c:forEach>
	
	</table>
	
	<a href="index.html">
		<button>Volver al menu principal</button>
	</a>
	
</body>
</html>