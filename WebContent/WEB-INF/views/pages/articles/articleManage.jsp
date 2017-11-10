<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/HelloSpring/css/ui/articleManage.css">
<title>教程管理</title>
</head>
<body style="background-color: #F5F5F5;">
	<%@include file="../fragment/header.jsp"%>
	<div style="min-height: 790px;">
		<!-- 左侧主题区 -->
		<div class="ContainerLeft">
			<h1 class="themeHeader">
				<span class="glyphicon glyphicon-align-left"> 主题</span>
			</h1>
			<hr>
			<!--教程主题列表 -->
			<ul id="themeListUL">
			</ul>
			<hr>
			<!-- 新建主题列表 -->
			<ul id="themeCreateList">
				<li class="themeLi hoverList" style="list-style-type: none;"
					onclick="addThemeBtnClick()"><span
					class="glyphicon glyphicon-plus">&nbsp;增加主题</span></li>
			</ul>
		</div>
		<!-- 隐藏的主题列表单元,用于js装填DOM元素 -->
		<ul id="themeLiDIV" style="display: none;">
			<li class="themeLi hoverList"><span class="themeName"></span> <!-- 隐藏的主题ID号 -->
				<span class="themeID" style="display: none;"></span>
				<div class="floatMenu">
					<span class="glyphicon glyphicon-edit editIcon"
						onclick="onThemeEdit(this);"></span> &nbsp;&nbsp;<span
						class="glyphicon glyphicon-trash trashIcon"
						onclick="onThemeDelete(this);"></span>
				</div></li>
		</ul>

		<!-- 隐藏的主题输入框 -->
		<ul id="themeInputCell" style="display: none;">
			<li class="themeInputLi">
				<!-- 用于主题编辑完成后移除输入框的标识 -->
				<div class="themeInputDIV">
					<input type="text" class="themeInput" maxlength="20"
						placeholder="输入主题名称 ">
					<button class="btn btn-default" onclick="onThemeInputBtnOK(this)">确认</button>
					<button class="btn btn-default" onclick="onThemeInputCancle(this)">X</button>
				</div>
			</li>
		</ul>

		<!--右侧教程管理区  -->
		<div class="ContainerRight">
			<h1>
				<span class="glyphicon glyphicon-align-left"> 教程管理</span>
			</h1>
			<a href="articleEdit0" class="creatArticle"><span
				class="glyphicon glyphicon-plus">新建教程</span></a> 主题&nbsp;<select
				id="selectTheme" onchange="onThemeSelect(this)"></select>
			<hr>
			<div>
				<!-- 教程列表 -->
				<ul id="articleListUL">
				</ul>
			</div>
		</div>
		<!-- 隐藏的教程列表单元 -->
		<ul id="articleLiDIV" style="display: none;">
			<li class="articleLi hoverList"><a class="articleTitle"></a> <!-- 隐藏的教程ID号 -->
				<span class="articleID" style="display: none;"></span>
				<div class="floatMenu">
					<span class="glyphicon glyphicon-edit editIcon"
						onclick="onArticleEdit(this)"></span> &nbsp;&nbsp;<span
						class="glyphicon glyphicon-trash trashIcon"
						onclick="onArticleDelete(this)"></span>
				</div></li>
		</ul>
	</div>
	<%@ include file="../fragment/footer.jsp"%>
	<script type="text/javascript"
		src="/HelloSpring/js/ui/articleManage.js"></script>
</body>
</html>