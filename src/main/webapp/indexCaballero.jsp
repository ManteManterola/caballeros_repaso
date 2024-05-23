<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Caballeros</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<c:if test="${msg=='insertOk'}">
		<div class="alert alert-success alert-dismissible fade show m-0"
			role="alert">
			<strong>Ok!</strong> El caballero se inserto correctamente.
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<a class="btn btn-secondary btn-lg mt-5" href="FormInsertCaballeros">CREAR CABALLERO</a>
	<a class="btn btn-secondary btn-lg mt-5" href="Lucha1Stage">LUCHAR</a>
	<form action="IndexCaballeros" method="get" class="mb-3">
        <input type="text" name="search" id="searchBox" class="form-control" placeholder="Buscar por nombre...">
    </form>
	<table class="table">
		<thead>
			<tr>
				<th scope="col"><strong>ID</strong></th>
				<th scope="col"><strong>Nombre</strong></th>
				<th scope="col"><strong>Fuerza</strong></th>
				<th scope="col"><strong>Experiencia</strong></th>
				<th scope="col"><strong>Foto</strong></th>
				<th scope="col"><strong>Arma</strong></th>
				<th scope="col"><strong>Escudo</strong></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${caballeros}" var="caballero">
				<tr>
					<td>${caballero.id}</td>
					<td>${caballero.nombre}</td>
					<td>${caballero.fuerza}</td>
					<td>${caballero.experiencia}</td>
					<td>${caballero.foto}</td>
					<td>${caballero.arma.nombre}</td>
					<td>${caballero.escudo.nombre}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>