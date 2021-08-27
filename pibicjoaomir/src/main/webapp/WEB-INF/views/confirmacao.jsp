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

label.check {
	cursor: pointer
}

label.check input {
	position: absolute;
	top: 0;
	left: 0;
	visibility: hidden;
	pointer-events: none
}

label.check span {
	padding: 7px 14px;
	border: 2px solid #8f37aa;
	display: inline-block;
	color: #8f37aa;
	border-radius: 3px;
	text-transform: uppercase
}

label.check input:checked+span {
	border-color: #8f37aa;
	background-color: #8f37aa;
	color: #fff
}
</style>
<body>
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>
	<div class="bg-image"
		style="background-image: url('https://st3.depositphotos.com/24812156/32404/i/450/depositphotos_324048386-stock-photo-futuristic-dots-background-color-music.jpg'); background-size: cover; width: 100%; height: 100vh;">
		<div class="mask"
			style="background-color: rgba(0, 0, 0, 0.8); width: 100%; height: 100vh;">
			<div class="container">
				<div class="row justify-content-lg-start">
					<div class="col-lg-auto">
						<h1 class="h1">An E-mail will be sent to ${email}, containing the features:</h1>
					</div>
				</div>
				<div class="row row-cols-4">
					<c:forEach items="${features}" var="feature">
						<div class="col" style="margin-top: 10px; margin-bottom: 10px;">
							<label class="check"> <input type="checkbox" checked>
								<span>${feature.split("\\.")[2]}</span>
							</label>
						</div>

					</c:forEach>
				</div>
				<div class="row justify-content-lg-start"style="margin-top: 80px">
					<div class="col-lg-auto">
						<h1 class="h1">The settled Data set:</h1>
					</div>
					<div class="col-lg-auto">
						<label class="check"> <input type="checkbox" checked>
							<span>${dataBase.split("\\.")[1]}</span>
						</label>
					</div>
					<div class="row justify-content-lg-start"style="margin-top: 80px">
						<div class="col-lg-auto">
							<h1 class="h1">The format file</h1>
						</div>
						<div class="col-lg-auto">
							<label class="check"> <input type="checkbox" checked>
								<span>${formato}</span>
							</label>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>