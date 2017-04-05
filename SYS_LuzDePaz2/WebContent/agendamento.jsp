<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agendamento de Visitas</title>
<script src="js/jquery-3.2.0.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

<script src="js/bootstrap.min.js"></script>
<script src="js/Validacao.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<style>
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}
</style>

</head>
<body  class="corpo">
    
	<div class="jumbotron">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">
					<h1>Agendamento de Visitas</h1>
				</a>
			</div>
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
				<li class="active"><a
					href="PrincipalController?comando=principal">Home</a></li>
				<li><a href="ClienteController?comando=listar">Cadastro de
						clientes</a></li>
				<li><a href="PlanosController?comando=listar">Cadastro de
						Planos</a></li>
				<li><a href="#">Agendamento de Visitas</a></li>
				<li><a href="ServicosController?comando=listar">Cadastro de Serviços</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sua Conta</a></li>
				
			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<form method="POST" action="AgendamentoController"
			onsubmit="return validaFormularioAgendamntos()">

			<div class="form-group col-md-3">
				<label for="codigo">Código</label> <input type="text"
					class="form-control" id="codigo" readonly="readonly"
					placeholder="código" name="codigo"
					value="<c:out value="${agenda.codigo}"/>">
			</div>

			<div class="form-group col-md-9">
				<label for="local">Local</label> <input type="text"
					class="form-control" id="local" placeholder="local"
					name="local" value="<c:out value="${agenda.local}"/>">
			</div>
			
			<div class="form-group col-md-3">
				<label for="datahora">Data/Hora da visita</label>
				<p>
					<input type="date" id="datahora" name="dataHora"
						class="form-control"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${agenda.dataHora}" />">
				</p>
			</div>
			
			<div class="form-group col-md-9">
				<label for="valor">Nome do Consultor</label> <input type="text"
					class="form-control" id="nomeConsultor" placeholder="nome do consultor" name="nomeConsultor"
					value="<c:out value="${agenda.nomeConsultor}"/>">
			</div>

			<input type="submit" class="btn btn-success" value="enviar" />
		</form>

	</div>
	<div class="container">
		<h2>Agendamentos</h2>

		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Local</th>
					<th>Nome Do Consultor</th>
					<th>Data/Hora da visita</th>
					<th colspan=2>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${agendas}" var="agenda">
					<tr>
						<td><c:out value="${agenda.codigo}" /></td>
						<td><c:out value="${agenda.local}" /></td>
						<td><c:out value="${agenda.nomeConsultor}" /></td>
						<td><fmt:formatDate pattern="dd-MM-yyyy" value="${agenda.dataHora}" /></td>
						<td><a
							href="AgendamentoController?comando=atualizar&codigo=<c:out value="${agenda.codigo}"/>">Atualizar</a></td>
						<td><a
							href="AgendamentoController?comando=excluir&codigo=<c:out value="${agenda.codigo}"/>">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<footer class="container-fluid text-center">
	<p>Footer Text</p>
	</footer>
</body>
</html>