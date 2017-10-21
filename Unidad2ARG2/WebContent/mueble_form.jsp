<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mueble_Tipo Form</title>
</head>
<body>
	<form action="MuebleController">
		<label>Descripcion:</label><br />
		<input type="text" name="descripcion" value="${mueble.descripcion}" /><br />
		<label>Nombre:</label><br />
		<input type="text" name="nombre" value="${mueble.nombre}" /><br />
		<label>Cantidad:</label><br />
		<input type="number" name="cantidad" value="${mueble.cantidad}" /><br />
		<label>Dueño:</label><br />
		<input type="text" name="duenio" value="${mueble.duenio}" /><br />
		<input type="submit" name="btn_save" value="Save" />
	</form>
</body>
</html>