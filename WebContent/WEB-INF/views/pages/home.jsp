<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String themeID = "0";
	/* 获取教程主题ID,用于加载教程列表时进行判断,若取值错误默认为0,即不按主题分类 */
	try {
		themeID = request.getAttribute("themeID").toString();
	} catch (Exception e) {
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hello Spring</title>
<link rel="stylesheet" href="/HelloSpring/css/ui/home.css">
</head>
<body style="background-color: #F4F5F7;">
	<%@ include file="fragment/header.jsp"%>
	<p id="themeID" style="display: none;"><%=themeID.trim()%></p>
	<%--首页主体内容--%>
	<div class="contentContainer"></div>
	<!-- contentContainer -->
	<%--分页--%>
	<div class="pageIndex">
		<ul class="pagination pagination-lg pageIndexUl">
		</ul>
	</div>

	<!-- 隐藏的教程列表的单元格 -->
	<div class="artListCell" style="display: none;">
		<div class="artListItem">
			<p class="artTheme"></p>
			<a href="#" class="artTitle"></a>
			<p class="artSummary"></p>
			<p class="artTime"></p>
		</div>
	</div>
	<!-- artListCell -->
	<div id="emptyTips" style="display: none;">
		<span class="glyphicon glyphicon-info-sign emptyInco"></span>
		<p class="emptyTip">暂时没有教程哦,敬请期待！</p>
	</div>

	<%@ include file="fragment/footer.jsp"%>
	<script type="text/javascript" src="/HelloSpring/js/ui/home.js"></script>
</body>
</html>