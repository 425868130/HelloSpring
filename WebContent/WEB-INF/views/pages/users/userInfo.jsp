<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户信息</title>
<link rel="stylesheet" href="/HelloSpring/css/ui/userInfo.css">
</head>
<body style="background-color: #F4F5F7">
	<%@ include file="../fragment/header.jsp"%>
	<div class="contentContainer">
		<div class="cover">
			<!-- 用户信息面板 -->
			<div class="userInfo">
				<div class="ImgAndSex">
					<%
						if (user != null && user.getUSex()) {
					%>
					<span class="userSex manUser">♂</span>
					<%
						} else if (user != null && !user.getUSex()) {
					%>
					<span class="userSex womanUser">♀</span>
					<%
						}
					%>
					<!-- 用户头像 -->
					<div class="userImg">
						<%
							if (user != null && user.getUImg() != null) {
						%>
						<img src="<%=user.getUImg()%>">
						<%
							} else {
						%>
						<span class="glyphicon glyphicon-user defaultImg"></span>
						<%
							}
						%>
					</div>
				</div>
				<div class="nickAndSign">
					<p class="userNick">${user.UNickName}</p>
					<p class="userSign">签名:${user.USign}</p>
					<p class="userEmail">邮箱:${user.UEmail }</p>
				</div>
				<span class="glyphicon glyphicon-pencil infoEdit"
					style="font-size: 25px;" data-toggle="modal"
					data-target="#InfoEditModal">编辑</span>
			</div>
			<!-- userInfo -->
		</div>
		<!-- cover -->

		<div class="floatBtnDiv">
			<span class="glyphicon glyphicon-edit floatBtn"></span><br>
			<p class="floatBtnTxt">写笔记</p>
		</div>
		<!-- 用户其他信息 -->
		<div class="middleDiv" style="display: none;">
			<div class="part1">
				<!-- 紫色竖线 -->
				<div class="hr backColor1"></div>
				<p class="titleUserInfo">
					<span class="glyphicon glyphicon-list-alt" style="color: #80397B;"></span>&nbsp;个人笔记
				</p>
				<hr>
				<!-- 笔记列表 -->
				<ul class="list noteList">
					<li><a href="#">笔记1 </a></li>
					<li><a href="#">笔记2</a></li>
					<li><a href="#">笔记3</a></li>
				</ul>
				<a class="magNote" href="#">管理笔记&gt;&gt;</a>
			</div>
			<div class="part2">
				<div class="hr"></div>
				<p class="titleUserInfo">
					<span class="glyphicon glyphicon-envelope"
						style="color: rgb(76, 175, 80);"></span>&nbsp;消息中心
				</p>
				<hr>
				<!-- 消息列表 -->
				<ul class="list msgList">
					<li><a href="#">消息1 </a></li>
					<li><a href="#">消息2 </a></li>
					<li><a href="#">消息3</a></li>
					<li><a href="#">消息4</a></li>
					<li><a href="#">消息5</a></li>
					<li><a href="#">消息6</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- contentContainer -->



	<!-- 模态框（Modal） -->
	<div class="modal fade" id="InfoEditModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="margin-top: 5%">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">个人信息修改</h4>
				</div>
				<!-- 模态框主体内容 -->
				<form action="userInfoChange" method="POST" id="userInfoForm">
					<div class="modal-body">
						<div class="input-group">
							<span class="input-group-addon">昵称:</span><input type="text"
								placeholder="昵称" class="form-control" name="nickName"
								value="${user.UNickName}">
						</div>
						<div class="input-group">
							<span class="input-group-addon">邮箱:</span> <input type="text"
								placeholder="邮箱" class="form-control" name="Email"
								value="${user.UEmail }">
						</div>
						<div class="input-group">
							<span class="input-group-addon">签名:</span> <input type="text"
								placeholder="签名" class="form-control" name="sign"
								value="${user.USign}">
						</div>
						<div class="input-group">
							<span class="input-group-addon">性别:</span> <select name="sex">
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</div>
					</div>
				</form>
				<div class="imgView">
					<img id="imgPreView" src="${user.UImg}"> <br>更换头像:<input
						id="ImgFileInput" type="file" accept="image/*">
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary"
						onclick="onUserInfoSumbit()">提交更改</button>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<%@ include file="../fragment/footer.jsp"%>
	<script type="text/javascript" src="/HelloSpring/js/ui/userInfo.js"></script>
</body>
</html>