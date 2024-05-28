<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>San dao</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
        <h1>Resultado de la Lucha</h1>
        <div class="card">
            <div class="card-body">
                <h3>Caballero 1</h3>
                <p><strong>ID:</strong> ${caballero1.id}</p>
                <p><strong>Nombre:</strong> ${caballero1.nombre}</p>
                <p><strong>Fuerza:</strong> ${caballero1.fuerza}</p>
                <p><strong>Experiencia:</strong> ${caballero1.experiencia}</p>
            </div>
        </div>
        <div class="card mt-3">
            <div class="card-body">
                <h3>Caballero 2</h3>
                <p><strong>ID:</strong> ${caballero2.id}</p>
                <p><strong>Nombre:</strong> ${caballero2.nombre}</p>
                <p><strong>Fuerza:</strong> ${caballero2.fuerza}</p>
                <p><strong>Experiencia:</strong> ${caballero2.experiencia}</p>
            </div>
        </div>
        <div class="card mt-3">
            <div class="card-body">
                <h3>Ganador</h3>
                <p><strong>ID:</strong> ${ganador.id}</p>
                <p><strong>Nombre:</strong> ${ganador.nombre}</p>
                <p><strong>Fuerza:</strong> ${ganador.fuerza}</p>
                <p><strong>Experiencia:</strong> ${ganador.experiencia}</p>
            </div>
        </div>
        <a href="IndexCaballeros" class="btn btn-secondary mt-3">Volver</a>
    </div>
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