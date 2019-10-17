<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleados</title>
</head>
<body>
	<table border="1px solid black">
	<tr>
		<th>Nombre</th>
		<th>DNI</th>
		<th>Sexo</th>
		<th>Categoria</th>
		<th>Años</th>
	</tr>
	
	<% List<String> empleados= (ArrayList<String>) request.getAttribute("listaEmpleados"); 
	  for (String empleado : empleados) {
	  String datos[] = empleado.split(",");
	  %>
	  
		<tr>
	    	<td><%=datos[0]%></td>
	    	<td><%=datos[1]%></td>
	    	<td><%=datos[2]%></td>
	    	<td><%=datos[3]%></td>
	    	<td><%=datos[4]%></td>
		</tr>
	<%}%>
	</table>
	<a href="index.html">
		<button>Volver</button>
	</a>
</body>
</html>