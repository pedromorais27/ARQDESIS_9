<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="./resources/js/jquery-2.2.2.js"></script>
<script src="./resources/js/bootstrap.js"></script>
<script src="./resources/js/extrato.js"></script>
<link rel="stylesheet" type="text/css"
	href="./resources/css/estrutura.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<%@ include file="menu-lateral.jsp"%>
		<div class="conteudo col-md-10">
			<div class="col-md-12">
				<h2 class="conteudo-titulo">Extrato</h2>
			</div>
			<form action="./extrato" method="POST">
				<div class=col-md-9>
					<div class="radio radio-data-extrato">
						<label><input type="radio" name="data"
							value="${dataAtual.minusDays(7)}">Últimos 7 dias</label> <label><input
							type="radio" name="data" value="${dataAtual.minusDays(15)}">Últimos
							15 dias</label> <label><input class="periodo-especifico"
							type="radio" name="data">Período específico</label>
					</div>
				</div>
				<div class=col-md-2>
					<input class="btn-lg btn-default" type="submit" value="Consultar" />
				</div>
				<div class=col-md-12>
					<!-- Colocar data selecionada aqui -->
				</div>

			</form>


			<c:if test="${not empty registros}">
				<div class=col-md-12>
					<table class="table table-extrato table-striped">
						<tr>
							<th>N. Documento</th>
							<th>Data Lançamento</th>
							<th>Operacao</th>
							<th>Lançamento</th>
							<th>Valor</th>
						</tr>
						<c:forEach items="${registros}" var="registro">
							<tr>
								<td>${registro.numeroDocumento}</td>
								<td>${registro.dataLancamento}</td>
								<td>${registro.tipoOperacao}</td>
								<td>${registro.tipoLancamento}</td>
								<td>${registro.valorDaOperacao}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
		</div>
	</div>

</body>
</html>