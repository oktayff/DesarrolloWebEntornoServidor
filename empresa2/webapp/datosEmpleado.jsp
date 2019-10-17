<%@page import="model.Empleado"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Datos Empleado</title>
</head>
<body>
	<%  Empleado emple = (Empleado) request.getAttribute("empleado"); 
		if(emple == null){ %>
			<h3>El empleado no existe</h3>
		<%} else { %>
	<form action="ModificarBaseDatos" method="post">
		Nombre: <input type="text" name="nombre" value="<%= emple.nombre %>"><br>
		DNI: <input type="text" name="dni" value="<%= emple.dni %>" readonly><br>
		Sexo: <input type="text" name="sexo" value="<%= emple.sexo %>"><br>
		Categoria: <input type="number" name="categoria" value="<%= emple.getCategoria() %>"> <br>
		Anyos: <input type="number" name="anyos" value="<%= emple.anyos%>"> <br>	
		<input class="boton" type="submit">
	</form>
	<br>
	
	<% } %>			
	
	<a href="index.jsp">
		<button class="boton">Volver</button>
	</a>
</body>
</html>