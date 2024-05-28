<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Se van a dar</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<h1>${caballero1.nombre}</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col"><strong>Fuerza</strong></th>
				<th scope="col"><strong>Experiencia</strong></th>
				<th scope="col"><strong>Foto</strong></th>
				<th scope="col"><strong>Arma</strong></th>
				<th scope="col"><strong>Escudo</strong></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${caballero1.fuerza}</td>
				<td>${caballero1.experiencia}</td>
				<td>${caballero1.foto}</td>
				<td>${caballero1.arma.nombre}</td>
				<td>${caballero1.escudo.nombre}</td>
			</tr>
		</tbody>
	</table>

	<h1>Se va a dar con ${caballero2.nombre}</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col"><strong>Fuerza</strong></th>
				<th scope="col"><strong>Experiencia</strong></th>
				<th scope="col"><strong>Foto</strong></th>
				<th scope="col"><strong>Arma</strong></th>
				<th scope="col"><strong>Escudo</strong></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${caballero2.fuerza}</td>
				<td>${caballero2.experiencia}</td>
				<td>${caballero2.foto}</td>
				<td>${caballero2.arma.nombre}</td>
				<td>${caballero2.escudo.nombre}</td>
			</tr>
		</tbody>
	</table>
	<form action="LuchaFinal" method="post">
	<input type="hidden" name="caballero1" value="${caballero1.id}" />
	<input type="hidden" name="caballero2" value="${caballero2.id}" />
	<button type="submit" class="btn btn-primary">Luchar</button>
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