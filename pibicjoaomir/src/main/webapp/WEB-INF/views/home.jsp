<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Web platform for music feature extraction</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@400;500;700&display=swap"
	rel="stylesheet">
</head>
<header>
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/pibicjoaomir/home">Rhapsody</a>
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item">
					<button type="button" class="btn btn-dark" data-bs-toggle="modal"
						data-bs-target="#sobreNosModal">About Us</button>
				</li>
			</ul>
			<div class="modal" id="sobreNosModal" tabindex="-1">
				<div class="modal-dialog modal-dialog-scrollable">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" style="color: #000000;">About Us</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<p style="color: #000000;">Texto explicando sobre a
								ferramenta e seus criadores...</p>
						</div>
					</div>
				</div>
			</div>

		</div>
	</nav>
</header>
<style>
body {
	color: #ffffff;
}
</style>
<body>
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
	<div class="bg-image"
		style="background-image: url('https://st3.depositphotos.com/24812156/32404/i/450/depositphotos_324048386-stock-photo-futuristic-dots-background-color-music.jpg'); background-size: cover;">
		<div class="mask"
			style="background-color: rgba(0, 0, 0, 0.5); height: 100vh;">
			<div class="d-flex justify-content-center align-items-center"
				style="height: 400px">
				<h1 class="h1">Choose the music features extraction tool
				</h1>
			</div>
			<form action="/pibicjoaomir/ferramenta" method="POST">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col">
							<select class="custom-select btn-lg" name="ferramenta" style="width: 70%; margin-left: 50%;">
								<c:forEach items="${ferramenta}" var="nomeFerramenta">
									<option value="${nomeFerramenta}">${nomeFerramenta}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col">
							<button type="submit" class="btn btn-outline-secondary btn-lg"
								style="margin-left: 20%;">Confirm</button>
						</div>
					</div>
				</div>
			</form>

		</div>
	</div>
</body>
</html>