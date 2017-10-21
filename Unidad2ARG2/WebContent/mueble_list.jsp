<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person list</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="MuebleController">
					<input type="submit" name="btn_new" 
					value="New" />
				</form>
			</th>
			<th>Codigo</th>
			<th>Descripcion</th>
			<th>Nombre</th>
			<th>Cantidad</th>
			<th>Dueño</th>
		</tr>
		<c:forEach var="mueble" items="${muebles}">
			<tr>
				<td>
					<form action="MuebleController">
						<input type="hidden" name="codigo" value="${mueble.codigo}">
						<input type="submit" name="btn_edit"
						value="Edit" />
						<input type="submit" name="btn_delete"
						value="Delete" />
					</form>
				</td>
				<td>${mueble.codigo}</td>
				<td>${mueble.descripcion }</td>
				<td>${mueble.nombre }</td>
				<td>${mueble.cantidad }</td>
				<td>${mueble.duenio }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>