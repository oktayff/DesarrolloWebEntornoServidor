<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Registrar nuevo admin</title>
</head>
<body>
	<h1>Registrar nuevo admin</h1>
	
	<form action="registrarAdmin.html" method="POST">
		USERNAME: <input type="text" name="username" value=""><br>
		PASSWORD: <input type="password" name="password" value=""><br>
		<br><input class="btn btn-warning" class="boton" type="submit" value="Registrar"><br>
	</form>
</body>
</html>