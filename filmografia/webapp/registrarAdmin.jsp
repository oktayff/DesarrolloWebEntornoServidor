<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar nuevo admin</title>
</head>
<body>
	<h1>Registrar nuevo admin</h1>
	
	<form action="Controller" method="POST">
		<input type="hidden" name="accion" value="nuevoadmin">
		USERNAME: <input type="text" name="username" value=""><br>
		PASSWORD: <input type="password" name="password" value=""><br>
		<br><input class="boton" type="submit" value="Registrar"><br>
	</form>
</body>
</html>