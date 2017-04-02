<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Luz de Paz</title>


<script src="js/jquery-3.2.0.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

<script src="js/bootstrap.min.js"></script>
<script src="js/Validacao.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/half-slider.css" rel="stylesheet">

<style>
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}
</style>

</head>
<body>
	<div class="jumbotron">
		<div class="container text-center">
			<h1>Luz de Paz</h1>
			<p>"Trazendo a paz nos momentos mais difíceis"</p>
		</div>
	</div>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="ClienteController?comando=listar">Cadastro de
						clientes</a></li>
				<li><a href="PlanosController?comando=listar">Cadastro de
						Planos</a></li>
				<li><a href="AgendamentoController?comando=listar">Agendamento de Visitas</a></li>
				<li><a href="ServicosController?comando=listar">Cadastro de Serviços</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Your Account</a></li>
				<li><a href="#"><span
						class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">BLACK FRIDAY DEAL</div>
					<div class="panel-body">
						<img src="https://placehold.it/150x80?text=IMAGE"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-danger">
					<div class="panel-heading">BLACK FRIDAY DEAL</div>
					<div class="panel-body">
						<img src="https://placehold.it/150x80?text=IMAGE"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-success">
					<div class="panel-heading">BLACK FRIDAY DEAL</div>
					<div class="panel-body">
						<img src="https://placehold.it/150x80?text=IMAGE"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
				</div>
			</div>
		</div>
	</div>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">BLACK FRIDAY DEAL</div>
					<div class="panel-body">
						<img src="https://placehold.it/150x80?text=IMAGE"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">BLACK FRIDAY DEAL</div>
					<div class="panel-body">
						<img src="https://placehold.it/150x80?text=IMAGE"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">BLACK FRIDAY DEAL</div>
					<div class="panel-body">
						<img src="https://placehold.it/150x80?text=IMAGE"
							class="img-responsive" style="width: 100%" alt="Image">
					</div>
					<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>

	<footer class="container-fluid text-center">
	<p>Footer Text</p>
	</footer>


</body>
</html>