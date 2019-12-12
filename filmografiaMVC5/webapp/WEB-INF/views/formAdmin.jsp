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
<title>Login</title>

</head>
<body>

	<h1 align="center">Formulario de login</h1><br>
	
	<form action="successfulLogin.html" method="POST">
		LOGIN: <input type="text" name="username" value=""><br>
		PASSWORD: <input type="password" name="password" value="">
		<input class="btn btn-warning" type="submit" value="Log In">
	</form>
	
	<a href="index.html">
		<button type="button" class="btn btn-warning">Volver</button>
	</a>
</body>
</html>