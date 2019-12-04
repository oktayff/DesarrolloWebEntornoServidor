<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edicion datos pelicula</title>

</head>
<body>
		<% Boolean resolucion = (Boolean) request.getAttribute("resolucion"); 
		if(resolucion != null){ 
			if( resolucion == true ) { %>
				<h3> Los datos han sido modificados satisfactoriamente </h3>
		<% }else{ %>
				<h3> No se han podido modificar los datos de la pelicula </h3>
		<% } }%>		
		
		<a href="mantPeliculas.jsp">
			<button class="boton">Intentar de nuevo</button>
		</a><br>
		<br>
		<a href="index.html">
			<button>Volver al menu principal</button>
		</a>

</body>
</html>