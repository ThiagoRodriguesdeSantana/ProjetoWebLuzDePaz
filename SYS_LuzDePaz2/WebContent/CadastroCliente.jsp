<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de cliente</title>


<script src="js/jquery-3.2.0.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

<script src="js/bootstrap.min.js"></script>
<script src="js/Validacao.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">

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
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">
					<h1>Cadastro de Clientes</h1>
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
				<li class="active"><a href="PrincipalController?comando=principal">Home</a></li>
				<li><a href="ClienteController?comando=listar">Cadastro de clientes</a></li>
				<li><a href="PlanosController?comando=listar">Cadastro de Planos</a></li>
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
		<form method="POST" action="ClienteController"
			onsubmit="return validaFormulario()">

			<div class="form-group col-md-3">
				<label for="codigo">Código</label> <input type="text"
					class="form-control" id="codigo" readonly="readonly"
					placeholder="código" name="codigo"
					value="<c:out value="${cliente.codigo}"/>">
			</div>

			<div class="form-group col-md-9">
				<label for="nome">Nome</label> <input type="text"
					class="form-control" id="nome" placeholder="nome" name="nome"
					value="<c:out value="${cliente.nome}"/>">
			</div>

			<div class="form-group col-md-12">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" placeholder="email" name="email"
					value="<c:out value="${cliente.email}"/>">
			</div>

			<div class="form-group col-md-3">
				<label for="cpf">CPF</label> <input type="text" class="form-control"
					id="cpf" placeholder="cpf" name="cpf"
					value="<c:out value="${cliente.cpf}"/>">
			</div>

			<div class="form-group col-md-3">
				<label for="telefone">Telefone</label> <input type="text"
					class="form-control" id="telefone" placeholder="telefone"
					name="telefone" value="<c:out value="${cliente.telefone}"/>">
			</div>

			<div class="form-group col-md-3">
				<label>Tipo de Usuário</label> <select class="form-control"
					name="tipoCliente" value="<c:out value="${cliente.tipoCliente}"/>">
					<option>Titular</option>
					<option>Dependente</option>
				</select>
			</div>

			<div class="form-group col-md-3">
				<label for="datepicker">Data de Nascimento</label>
				<p>
					<input type="date" id="dataNascimento" name="dataNascimento"
						class="form-control"
						value="<fmt:formatDate pattern="MM/dd/yyyy" value="${cliente.dataNascimento}" />">
				</p>
			</div>

			<div class="form-group col-md-3">
				<label for="cep">CEP</label> <input type="text" class="form-control"
					id="cep" name="cep" placeholder="cep"
					value="<c:out value="${cliente.endereco.cep}"/>">
			</div>

			<div class="form-group col-md-3">
				<label for="Rua">Rua</label> <input type="text" class="form-control"
					id="rua" name="rua" placeholder="rua"
					value="<c:out value="${cliente.endereco.rua}"/>">
			</div>

			<div class="form-group col-md-6">
				<label for="comp">Complemento</label> <input type="text"
					class="form-control" id="complemento" name="complemento"
					placeholder="complemento"
					value="<c:out value="${cliente.endereco.complemento}"/>">
			</div>

			<div class="form-group col-md-6">
				<label for="bairro">Bairro</label> <input type="text"
					class="form-control" id="bairro" name="bairro" placeholder="bairro"
					value="<c:out value="${cliente.endereco.bairro}"/>">
			</div>

			<div class="form-group col-md-3">
				<label>Cidade</label> <select class="form-control" id="cidade"
					name="cidade" value="<c:out value="${cliente.endereco.cidade}"/>">
					<option>Goiania</option>
					<option>Trindade</option>
					<option>Aparecida de Goiania</option>
					<option>Goianira</option>
					<option>Senador Canedo</option>
					<option>Neropolis</option>
				</select>
			</div>
			<div class="form-group col-md-3">
				<label>Cidade</label> <select class="form-control" id="estado"
					name="estado" value="<c:out value="${cliente.endereco.estado}"/>">
					<option>Goias</option>
				</select>
			</div>

			<input type="submit" class="btn btn-success" value="enviar" />
		</form>

	</div>
	<div class="container">
		<h2>Clientes Cadastrados</h2>

		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Telefone</th>
					<th colspan=2>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clientes}" var="cliente">
					<tr>
						<td><c:out value="${cliente.codigo}" /></td>
						<td><c:out value="${cliente.nome}" /></td>
						<td><c:out value="${cliente.email}" /></td>
						<td><c:out value="${cliente.telefone}" /></td>
						<td><a
							href="ClienteController?comando=atualizar&codigo=<c:out value="${cliente.codigo}"/>">Atualizar</a></td>
						<td><a
							href="ClienteController?comando=excluir&codigo=<c:out value="${cliente.codigo}"/>">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<footer class="container-fluid text-center">
	<p>Footer Text</p>
	</footer>

</body>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</html>