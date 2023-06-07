<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="model.JavaBeans" %>
    <%@page import="java.util.ArrayList" %>
    <%
    	@ SuppressWarnings("unchecked")
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");   	
    %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Agenda de contatos</title>
		<link rel="icon" href="imagens/favicon.png">
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<h1>Agenda de Contatos</h1>
		<a href="novo.html" class="Botao1" >Noovo Contato</a>
		<a href="report" class="Botao2">Relatório</a>
		<table id="tabela">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Fone</th>
					<th>Email</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<%for(JavaBeans contatos : lista){ %>
					<tr>
						<td><%=contatos.getId() %></td>
						<td><%=contatos.getNome() %></td>
						<td><%=contatos.getFone() %></td>
						<td><%=contatos.getEmail() %></td>
						<td>
							<a href="select?id=<%=contatos.getId()%>" class="Botao1">Editar</a>
							<a href="javascript: confirmar(<%=contatos.getId()%>)" class="Botao2">Excluir</a>
						</td>
					</tr>
				<%} %>
			</tbody>
		</table>
		<script src="scripsts/confirmador.js"></script>
	</body>
</html>