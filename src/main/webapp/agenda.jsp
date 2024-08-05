<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> listContatos = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="images/telephone_icon.png">
<link rel="stylesheet" href="static/bootstrap.min.css">
<title>Agenda</title>
</head>
<body>
	<div
		class="d-flex flex-column justify-content-center align-items-center container "
		style="height: 100vh">
		<div class="card shadow p-3 mb-5 bg-body-tertiary rounded"
			style="width: 30rem;">
			<div
				class="card-body d-flex justify-content-center flex-column gap-3">
				<h1 class="text-center">Agenda de Contatos</h1>
				<div class="d-flex justify-content-center ">
					<a href="novo_contato.jsp" role="button" class="btn btn-success">Novo
						Contato</a>
				</div>
			</div>
		</div>
		<table
			class="table table-striped shadow p-3 mb-5 bg-body-tertiary rounded">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Fone</th>
					<th>Email</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < listContatos.size(); i++) {
				%>
				<tr>
					<td><%=listContatos.get(i).getId()%></td>
					<td><%=listContatos.get(i).getNome()%></td>
					<td><%=listContatos.get(i).getFone()%></td>
					<td><%=listContatos.get(i).getEmail()%></td>
					<td><a href="select?id=<%=listContatos.get(i).getId()%>"
						class="btn btn-warning">Alterar</a></td>
					<td><button class="btn btn-danger" onclick="confirma(<%=listContatos.get(i).getId()%>)">Excluir</button></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<script type="text/javascript" src="static/bootstrap.min.js"></script>
	<script>
	function confirma(id)
	{
		let resposta = confirm("confirmar exclusão")
		if (resposta === true)
		{
			window.location.href = "delete?id="+id
		}
	}
	</script>
</body>
</html>