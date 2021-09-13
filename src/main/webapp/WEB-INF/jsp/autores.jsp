<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autores</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
</head>
<body class="container">
	<h1 class="text-center">CADASTRO DE AUTOR</h1>
	<form action="<c:url value="/autores"/>" method="POST">
		<div>
			<label for="nome">Nome</label> 
			<input id="nome" class="form-control" name="nome">
		</div>
		<div>
			<label for="email">Email</label> 
			<input id="email" class="form-control" name="email">
		</div>
		<div>
			<label for="dataNascimento">Data de nascimento</label> 
			<input id="dataNascimento" class="form-control" name="dataNascimento">
		</div>	
		<div>
			<label for="miniCurriculo">Mini curriculo</label> 
			<input id="miniCurriculo" class="form-control" name="miniCurriculo">
		</div>
		
		<input type="submit" value="cadastrar" class="mt-2 btn-primary">
	</form>
	<h1 class="text-center">LISTA DE AUTOR</h1>
	<table class="table table-hover table-striped table-bordered">
		<thead>
			<tr>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>DATA DE NASCIMENTO</th>
			</tr>
		<tbody>
			<c:forEach items="${autores}" var="a">
				<tr>
					<td>${a.nome}</td>
					<td>${a.email}</td>
					<td>${a.dataNascimento}</td>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>