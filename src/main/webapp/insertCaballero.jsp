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
    <form action="StoreCaballeros" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        
        <label for="fuerza">Fuerza:</label>
        <input type="number" id="fuerza" name="fuerza" required><br><br>
        
        <label for="experiencia">Experiencia:</label>
        <input type="number" id="experiencia" name="experiencia" required><br><br>
        
        <label for="foto">Foto (URL):</label>
        <input type="text" id="foto" name="foto" required><br><br> 
        
        <label for="idArma">Arma:</label> 
		<select name="idArma" required>
		    <option value="0"></option>
		    <c:forEach var="arma" items="${armas}">
		        <option value="${arma.id}">${arma.nombre}</option>
		    </c:forEach>
		</select><br><br>

		<label for="idEscudo">Escudo:</label> 
		<select name="idEscudo" required>
		    <option value="0"></option>
		    <c:forEach var="escudo" items="${escudos}">
		        <option value="${escudo.id}">${escudo.nombre}</option>
		    </c:forEach>
		</select><br><br>

<input type="submit" value="Crear">
        
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