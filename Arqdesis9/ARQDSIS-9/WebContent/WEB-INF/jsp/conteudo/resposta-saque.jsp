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
				<h2 class="conteudo-titulo">Saque</h2>
			</div>
			<c:if test="${sucesso}">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<p class="text-danger">Saque realizado com sucesso.</p>
					</div>
				</div>
			</c:if>
			
			<c:if test="${not sucesso}">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<p class="text-danger">Ocorreu um erro.</p>
					</div>
				</div>
			</c:if>
		</div>
	</div>

</body>
</html>