<%@page import="hellospring.controller.UserController"%>
<%@page import="hellospring.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("User");
%>
<link rel="stylesheet"
	href="/HelloSpring/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/HelloSpring/css/ui/header.css">
<script type="text/javascript"
	src="/HelloSpring/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/HelloSpring/js/bootstrap/bootstrap.min.js"></script>
<!--导航栏-->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<!--此处为网页缩小后右侧的汉堡按钮-->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle burgerMenu"
			style="background: inherit; border: none;" data-toggle="collapse"
			data-target=".navbar-collapse" onclick="changeColor()">
			<span class="icon-bar" style="background: white;"></span> <span
				class="icon-bar" style="background: white;"></span> <span
				class="icon-bar" style="background: white;"></span>
		</button>
		<a class="navbar-brand" style="cursor: default"> <span
			class="glyphicon glyphicon-leaf"
			style="color: white; font-size: 32px">&nbsp;<i>Hello
					Spring</i></span></a>
	</div>
	<div class="collapse navbar-collapse">
		<!--组件列表-->
		<ul class="nav navbar-nav navbar-right nav-list articleThemelist">
			<%
				if (user == null) {
			%>
			<li><a href="login" style="color: white;">&nbsp;[&nbsp;&nbsp;登录</a></li>
			<li><a href="userReg" style="color: white;">注册&nbsp;]</a></li>
			<%
				} else {
			%>
			<li class="dropdown"><a href="#"
				style="color: white; background: rgb(76, 175, 80); border: none;"
				class="btn dropdown-toggle" id="dropdownMenu1"
				data-toggle="dropdown">[&nbsp;<%=user.getUNickName()%>&nbsp;] <span
					class="caret" style="font-size: 25px;"></span>
			</a>
				<ul class="dropdown-menu dropdownMenu" role="menu"
					aria-labelledby="dropdownMenu1">
					<li><a href="userInfo" tabindex="-1" style="color: white;">个人中心</a></li>
					<!-- <li><a href="noteList" tabindex="-1" style="color: white;">学习笔记</a></li> -->
					<%
						if (user.getUType() == 0 || user.getUType() == 2) {
					%>
					<li><a href="articleManage" tabindex="-1"
						style="color: white;">教程管理</a></li>
					<%
						}
					%>
					<li role="presentation" class="divider"></li>
					<li><a href="logout" tabindex="-1" style="color: white;">&nbsp;注销</a></li>
				</ul></li>
			<%
				}
			%>
		</ul>
	</div>
	<!--collapse -->
</div>
<script type="text/javascript">
	/* 获取主题列表 */
	$(function() {
		$.ajax({
			url : "themeList",
			type : "POST",
			dataType : "json",
			success : function(data) {
				showThemeList(data);
			}
		});
	});
	function showThemeList(data) {
		var articleThemelist = $(".articleThemelist");
		var $themeLiDOM = $("<div><li><a style='color: white;''></a></li></div>");
		var themeLink = $themeLiDOM.find("a");
		$.each(data, function(i) {
			themeLink.attr("href", "home" + data[i].ThemeID);
			themeLink.html("&nbsp" + data[i].TName);
			articleThemelist.prepend($themeLiDOM.html());
		});
	}
</script>