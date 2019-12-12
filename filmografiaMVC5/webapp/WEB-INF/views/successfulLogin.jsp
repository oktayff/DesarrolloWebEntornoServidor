<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Login exitoso</title>
</head>
<body>
	
	<br>
	<a href="formAdmin.html">
		<button class="btn btn-info mx-auto d-block">Login con otro usuario</button>
	</a><br>

	<form action="mantPeliculas.html" method="POST">
		<button class="btn btn-info mx-auto d-block">Mantenimiento peliculas</button>
	</form><br>

	<a href="registroAdmin.html">
		<button class="btn btn-info mx-auto d-block">Registrar</button>
	</a><br>

	<a href="index.html">
		<button class="btn btn-info mx-auto d-block">Volver al menu principal</button>
	</a><br>
	
	<br>
	<p align="center">${msg }</p>
</body>
</html>