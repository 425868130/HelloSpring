<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户登录</title>
<link rel="stylesheet"
	href="/HelloSpring/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/HelloSpring/css/ui/login.css">
</head>
<body>
	<div class="formContainer">
		<a class="goHome" href="home">查看教程</a>
		<div class="hr"></div>
		<form method="POST" action="login" id="loginForm">
			<p style="color: #727F80; font-size: 22px">用户登录</p>
			<input name="UCount" type="text" class="inputArea" placeholder="你的账号"
				id="UCount" /> <input name="PsWd" type="password" class="inputArea"
				placeholder="密码" id="PsWd" />
			<div class="alert alert-danger errorTip">${msg}</div>
			<a class="btn btn-ToReg" href="userReg">注册</a>
			<button class="btn btn-login" onclick="onLogin()">登录</button>
		</form>
	</div>
	<%@ include file="../fragment/introduction.jsp"%>

	<script type="text/javascript"
		src="/HelloSpring/js/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="/HelloSpring/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/HelloSpring/js/ui/loginReg.js"></script>
</body>
</html>