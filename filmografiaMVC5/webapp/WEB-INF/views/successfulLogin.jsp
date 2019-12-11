<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login exitoso</title>
</head>
<body>
	<h1>Datos introducidos</h1>
	
	<table border="1px solid black">
	<tr>
		<th>USERNAME</th>
		<th>PASSWORD</th>
	</tr>
	
	<c:forEach items="${usuarios}" var="usuario">
	  
		<tr>
	    	<td>${usuario.username}</td>
	    	<td>${usuario.password}</td>
		</tr>
		
	</c:forEach>
	
	</table>
	<br>
	
	<a href="formAdmin.html">
		<button>Volver</button>
	</a><br>
	<br>
	<a href="mantPeliculas.html">
		<button>Mantenimiento peliculas</button>
	</a><br>
	<br>
	<a href="registroAdmin.html">
		<button>Registrar</button>
	</a><br>
	<br>
	<a href="index.html">
		<button>Volver al menu principal</button>
	</a>
	
	<p>${msg }</p>
</body>
</html>