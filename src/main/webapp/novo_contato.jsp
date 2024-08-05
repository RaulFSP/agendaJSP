<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="images/telephone_icon.png">
<link rel="stylesheet" href="static/bootstrap.min.css">
<title>Agenda</title>
<body>
	<div class="container d-flex flex-column mb-3 gap-3 justify-content-center align-items-center"
		style="height: 100vh">
		<h1>Criar novo contato</h1>
		<form method="get" action="insert" name="formContato" class="container p-3 d-flex gap-3 flex-md-column border border-2 rounded shadow mb-5 bg-body-tertiary rounded">
		<input class="form-control" placeholder="nome" name="nome" maxlength="50" required>
		<input class="form-control" placeholder="fone" name="fone" maxlength="50" required>
		<input class="form-control" placeholder="email" name="email" maxlength="50" required>
		<div class="d-flex justify-content-around ">
			<a role="button" href="index" class="btn btn-warning">Voltar</a>
			<input type="submit" role="button" class="btn btn-success" value="Adicionar">	
		</div>
		</form>
		</div>
	<script type="text/javascript" src="static/bootstrap.min.js"></script>
	
</body>
</html>