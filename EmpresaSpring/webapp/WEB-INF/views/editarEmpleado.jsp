<%@page import="laboral.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edicion del empleado</title>

</head>
<body>
	
	<form action="Controller" method="post">
		<input type="hidden" name="accion" value="modificarempleado">
		NOMBRE: <input type="text" name="nombre" value="${empleado.nombre}"> <br>
		DNI: <input type="text" name="dni" value="${empleado.dni}"> <br>
		SEXO: <input type="text" name="sexo" value="${empleado.sexo}"> <br>
		CATEGORIA: <input type="number" name="categoria" value="${empleado.categoria}"> <br>
		ANYOS: <input type="number" name="anyos" value="${empleado.anyos}"> <br>	
		<input class="boton" type="submit" value="Enviar">
	</form>
	<br>
	
	<a href="index.html">
		<button class="boton">Volver al menu principal</button>
	</a>
	
</body>
</html>