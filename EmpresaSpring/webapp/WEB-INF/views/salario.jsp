<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="laboral.BBDD" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salario del empleado</title>
</head>
<body>

	<c:out value="${respuesta}"></c:out>
	
	<a href="index.html">
		<button class="boton">Volver al menu principal</button>
	</a>

</body>
</html>