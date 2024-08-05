<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%
JavaBeans contato = (JavaBeans) request.getAttribute("contato");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="images/telephone_icon.png">
<link rel="stylesheet" href="static/bootstrap.min.css">
<title>Alterar Contato</title>
</head>
<body>
	<div
		class="container d-flex flex-column mb-3 gap-3 justify-content-center align-items-center"
		style="height: 100vh">
		<h1>Alterar contato</h1>
		<form method="get" action="update" name="formAlterarContato"
			class="container p-3 d-flex gap-3 flex-md-column border border-2 rounded shadow mb-5 bg-body-tertiary rounded">
			<input type="hidden" name="id" value="<%=contato.getId()%>">
			<input class="form-control" name="nome" maxlength="50" required
				value="<%=contato.getNome()%>"> <input class="form-control"
				name="fone" maxlength="50" required value="<%=contato.getFone()%>">
			<input class="form-control" name="email" maxlength="50" required
				value="<%=contato.getEmail()%>">
			<div class="d-flex justify-content-around ">
				<a role="button" href="index" class="btn btn-warning">Voltar</a> 
				<input type="submit" role="button" class="btn btn-success" value="Alterar">
			</div>
		</form>
	</div>
	<script type="text/javascript" src="static/bootstrap.min.js"></script>
</body>
</html>