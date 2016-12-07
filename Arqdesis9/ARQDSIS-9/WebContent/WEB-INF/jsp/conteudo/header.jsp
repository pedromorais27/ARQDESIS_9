<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="./resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="./resources/css/estrutura.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Caixa Eletronico</title>
</head>
<body>
	<!-- Titulo -->
	<div class="container menu-titulo">
		<div class="col-md-11">
			<h1>Bem Vindo, ${conta.nome}</h1>
		</div>
		<div class="col-md-1">
			<a class="btn btn-sair" href="./sair">Sair</a>
		</div>
	</div>
</body>
</html>