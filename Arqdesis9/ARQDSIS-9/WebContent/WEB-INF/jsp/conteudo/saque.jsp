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
			<div class="col-md-12 conteudo-saque">
			
			
				<form action="Saque" method="POST">
					<div class="col-md-3 botao-esquerda">
						<button class="btn-lg btn-default" value="10" name="valor">R$
							10,00</button>
						<button class="btn-lg btn-default" value="20" name="valor">R$
							20,00</button>
						<button class="btn-lg btn-default" value="50" name="valor">R$
							50,00</button>
					</div>
					<div class="col-md-6 botao-meio">
						<input type="text" name="valor" /> <input type="submit"
							value="Sacar" />

					</div>
					<div class="col-md-3 botao-direito">
						<button class="btn-lg btn-default" value="100" name="valor">R$
							100,00</button>
						<button class="btn-lg btn-default" value="200" name="valor">R$
							200,00</button>
						<button class="btn-lg btn-default" value="500" name="valor">R$
							500,00</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>