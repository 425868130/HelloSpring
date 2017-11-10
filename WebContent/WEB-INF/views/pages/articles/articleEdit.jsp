<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/* articleID为0表示新建教程，否则为对应教程id的编辑 */
	int articleID = 0;
	if (request.getAttribute("articleID") != null) {
		articleID = (int) request.getAttribute("articleID");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教程编辑</title>
<link rel="stylesheet" href="/HelloSpring/js/summerNote/summernote.css">
<link rel="stylesheet" href="/HelloSpring/css/ui/articleEdit.css">
</head>
<body style="background-color: #F5F5F5;">
	<%@include file="../fragment/header.jsp"%><!-- 用于标识当前页面是新建教程页还是教程编辑页 -->
	<p id="pageFlag" style="display: none;"><%=articleID%></p>
	<div class="main">
		<h1 class="title">
			<%
				/* 根据教程ID变更页面标题 */
				if (articleID == 0) {
			%>
			创建教程&nbsp;
			<%
				} else {
			%>教程编辑&nbsp;
			<%
				}
			%>
			<span class="glyphicon glyphicon-edit"></span>
		</h1>
		<div class="articleTitleEdit">
			<span class="font20">教程标题:</span> <input type="text"
				id="inputArtTitle"><br> <br> <span class="font20">教程摘要:</span><br>
			<textarea id="articleSummary"></textarea>
		</div>
		<div id="summerNoteDIV">
			<p class="font20">教程内容:</p>
			<div id="summerNote" style="display: block;"></div>
			<div id="buttonGroup">
				<span class="font20">主题:&nbsp;</span><select id="themeSelect">
				</select>
				<button class="btn btn-success sumbitArticle"
					onclick="submitArticle()">提交</button>
			</div>
		</div>
	</div>
	<%@ include file="../fragment/footer.jsp"%>
	<script type="text/javascript"
		src="/HelloSpring/js/summerNote/summernote.js"></script>
	<script type="text/javascript"
		src="/HelloSpring/js/summerNote/lang/summernote-zh-CN.js"></script>
	<script type="text/javascript" src="/HelloSpring/js/ui/articleEidt.js"></script>
</body>
</html>