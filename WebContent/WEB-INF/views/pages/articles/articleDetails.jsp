<%@page import="hellospring.model.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Article article;

	article = (Article) request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教程详情</title>
<link rel="stylesheet" href="/HelloSpring/css/ui/articleDetails.css">
</head>
<body style="background: #F5F5F5;">
	<%@include file="../fragment/header.jsp"%>
	<!-- 侧边导航栏 -->
	<div class="sideNavigation">
		<p class="navTitle">相关教程</p>
		<hr style="height: 1px; border-top: 1px solid #DDDDDD;" />
		<ul class="otherArticles">
			<li><a href="#">[Spring MVC]&nbsp;快速入门Spring MVC</a></li>
			<li><a href="#">[Spring MVC]&nbsp;快速入门Spring MVC</a></li>
			<li><a href="#">[Spring MVC]&nbsp;快速入门Spring MVC</a></li>
			<li><a href="#">[Spring MVC]&nbsp;快速入门Spring MVC</a></li>
		</ul>
	</div>
	<!-- 教程内容主体 -->
	<div class="contentContainer">
		<%
			if (article != null) {
		%>
		<br>
		<h1><%=article.getTitle()%></h1>
		<div class="articleInfo">
			<span>发布时间:<%=article.getUpTime().toLocaleString()%></span> <br>
			<span>所属主题: [<%=article.getThemeName()%>]
			</span>
		</div>
		<hr>
		<div class="articleContent"><%=article.getContent()%></div>
		<p class="articleCopyright">© 著作权归作者所有,转载请注明出处</p>
		<%
			}
		%>
	</div>
	<%--留言区--%>
	<p class="commentTip">留言</p>
	<div class="commentArea">
		<div>
			<input class="articleAuthor" value="<%=article.getAuthorID()%>"
				style="display: none;">
			<textarea class="input-lg commentInput" placeholder="说点什么吧..."></textarea>
			<button class="btn btn-success btn-lg btn-comment"
				onclick="SendComment(<%=article.getArticleID()%>);">发表留言</button>
		</div>
		<ul class="commentList">
		</ul>
	</div>

	<%@ include file="../fragment/footer.jsp"%>
	<script type="text/javascript">
		$(function() {
			loadArtComment(<%=article.getArticleID()%>);
		});
	</script>
	<script type="text/javascript"
		src="/HelloSpring/js/ui/articleDetails.js"></script>
</body>
</html>