<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar producto</title>
</head>
<body>
	<h1> CREACION DEL PRODUCTO</h1>
	
	<form action="ProductoController" method="post">
	<input type="hidden" name="opcion" value="guardar">
		<table border="1">
 			 <tr>
				<td>Nombre:</td>
				<td><input type="text" name="txtnombre" size="50"></td>
			 </tr>
			 
			 <tr>
				<td>Cantidad:</td>
				<td><input type="text" name="txtcantidad" size="50"></td>
			 </tr>
			 
			 <tr>
				<td>Precio:</td>
				<td><input type="text" name="txtprecio" size="50"></td>
			 </tr>
	
		</table>
		
		<input type="submit" value="Guardar" name="btnguardar">
	
	
	</form>	
</body>
</html>