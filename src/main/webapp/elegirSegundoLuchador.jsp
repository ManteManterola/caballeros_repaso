<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elegir luchador 2</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<a class="btn btn-secondary btn-lg mt-5" href="IndexCaballeros">PAGINA
		PRINCIPAL</a>
		
	<h1>Primer luchador</h1>
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
					<tr>
						<td>${caballero1.id}</td>
						<td>${caballero1.nombre}</td>
						<td>${caballero1.fuerza}</td>
						<td>${caballero1.experiencia}</td>
						<td>${caballero1.foto}</td>
						<td>${caballero1.arma.nombre}</td>
						<td>${caballero1.escudo.nombre}</td>
					</tr>
			</tbody>
		</table>
		
	<h1>Elige el segundo luchador</h1>
	<form action="FaceOff" method="post">
	 <input type="hidden" name="caballero1" value="${caballero1.id}" />
		<table class="table">
			<thead>
				<tr>
					<th scope="col"></th>
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
						<td><input type="radio" name="caballero2"
							value="${caballero.id}" required></td>
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
		<button type="submit" class="btn btn-primary">Siguiente</button>
	</form>
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
