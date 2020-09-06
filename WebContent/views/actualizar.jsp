<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar productos</title>
</head>
<body>
<h1>ACTALIZACION DE PRODUCTOS</h1>

<form action="ProductoController" method="post">

<c:set var="producto" value="${producto}"> </c:set>
	<input type="hidden" name="opcion" value="actualizar">
	<input type="hidden" name="id" value="${producto.id}">
		<table border="1">
 			 <tr>
				<td>Nombre:</td>
				<td><input type="text" name="txtnombre" size="50" value="${producto.nombre }"></td>
			 </tr>
			 
			 <tr>
				<td>Cantidad:</td>
				<td><input type="text" name="txtcantidad" size="50" value="${producto.cantidad }"></td>
			 </tr>
			 
			 <tr>
				<td>Precio:</td>
				<td><input type="text" name="txtprecio" size="50" value="${producto.precio }"></td>
			 </tr>
	
		</table>
		
		<input type="submit" value="Guardar" name="btnguardar">
	
	
	</form>	
	
</body>
</html>