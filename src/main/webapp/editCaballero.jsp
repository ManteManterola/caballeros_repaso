<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar caballero</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
        <h1>Editar Caballero</h1>
        <form action="EditarCaballero" method="post">
            <input type="hidden" name="id" value="${caballero.id}" />
            
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" value="${caballero.nombre}" required>
            </div>
            
            <div class="mb-3">
                <label for="fuerza" class="form-label">Fuerza:</label>
                <input type="number" id="fuerza" name="fuerza" class="form-control" value="${caballero.fuerza}" required>
            </div>
            
            <div class="mb-3">
                <label for="experiencia" class="form-label">Experiencia:</label>
                <input type="number" id="experiencia" name="experiencia" class="form-control" value="${caballero.experiencia}" required>
            </div>
            
            <div class="mb-3">
                <label for="foto" class="form-label">Foto (URL):</label>
                <input type="text" id="foto" name="foto" class="form-control" value="${caballero.foto}">
            </div>
            
            <div class="mb-3">
                <label for="idArma" class="form-label">Arma:</label>
                <select id="idArma" name="idArma" class="form-select">
                    <c:forEach var="arma" items="${armas}">
                        <option value="${arma.id}" ${arma.id == caballero.arma.id ? 'selected' : ''}>${arma.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="mb-3">
                <label for="idEscudo" class="form-label">Escudo:</label>
                <select id="idEscudo" name="idEscudo" class="form-select">
                    <c:forEach var="escudo" items="${escudos}">
                        <option value="${escudo.id}" ${escudo.id == caballero.escudo.id ? 'selected' : ''}>${escudo.nombre}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        </form>
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