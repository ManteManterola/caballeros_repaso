<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear caballero</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
 <h1>Registrar Caballero</h1>
	<c:if test="${msg=='insertError'}">
		<div class="alert alert-danger alert-dismissible fade show m-0"
			role="alert">
			<strong>Error al insertar</strong>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
    <form action="StoreCaballeros" method="post">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre">
        </div>

        <div class="mb-3">
            <label for="fuerza" class="form-label">Fuerza:</label>
            <input type="number" class="form-control" id="fuerza" name="fuerza">
        </div>

        <div class="mb-3">
            <label for="experiencia" class="form-label">Experiencia:</label>
            <input type="number" class="form-control" id="experiencia" name="experiencia">
        </div>

        <div class="mb-3">
            <label for="foto" class="form-label">Foto (URL):</label>
            <input type="text" class="form-control" id="foto" name="foto">
        </div>

        <div class="mb-3">
            <label for="idArma" class="form-label">Arma:</label>
            <select class="form-select" name="idArma">
                <option value="0"></option>
                <c:forEach var="arma" items="${armas}">
                    <option value="${arma.id}">${arma.nombre}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="idEscudo" class="form-label">Escudo:</label>
            <select class="form-select" name="idEscudo">
                <option value="0"></option>
                <c:forEach var="escudo" items="${escudos}">
                    <option value="${escudo.id}">${escudo.nombre}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Crear</button>
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