<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Title</title>
<link rel="stylesheet"
	href="/HelloSpring/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/HelloSpring/css/ui/userReg.css">
</head>
<body>
	<div class="formContainer">
		<a class="goHome" href="home">查看教程</a>
		<div class="hr"></div>
		<form method="POST" action="userReg">
			<p style="color: #727F80; font-size: 22px">用户注册<a class="returnLogin" href="login">返回登录</a> </p>
			<input name="UCount" type="text" class="inputArea" placeholder="你的账号" />
			<input name="PsWd" type="password" class="inputArea" placeholder="密码" />
			<input name="PswdConfirm" type="password" class="inputArea" placeholder="确认密码" />
			<input name="Email" type="text" class="inputArea" placeholder="邮箱" />
			<input class="btn btn-UserReg" type="submit" value="注册"><br>
			<div class="alert alert-danger errorTip">${msg}</div>
		</form>
	</div>
	<%@ include file="../fragment/introduction.jsp"%>
	<script type="text/javascript"
		src="/HelloSpring/js/jquery/jquery.min.js"></script>
	<script type="/HelloSpring/text/javascript"
		src="/HelloSpring/js/bootstrap/bootstrap.min.js"></script>
		<script type="text/javascript">
		$(function() {
			var errorTip = $(".errorTip");
			if (errorTip.html().length == 0) {
				errorTip.css("display", "none");
			}
		});
		</script>
</body>
</html>