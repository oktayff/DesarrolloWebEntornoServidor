<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

</head>
<body>

	<h1 align="center">Formulario de login</h1><br>
	
	<form action="successfulLogin.html" method="POST">
		LOGIN: <input type="text" name="username" value=""><br>
		PASSWORD: <input type="password" name="password" value="">
		<input class="boton" type="submit" value="Log In">
	</form>
	
	<a href="index.html">
		<button>Volver</button>
	</a>
</body>
</html>