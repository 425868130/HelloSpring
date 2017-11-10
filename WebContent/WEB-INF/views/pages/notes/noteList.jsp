<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户笔记列表</title>
</head>
<body>
	<%@include file="../fragment/header.jsp"%>
	<div class="main">
		<h1>学习笔记</h1>
		<a href="#" onclick="show()">创建笔记</a>
		<div style="display: none;" id="NoteDiv">
			<form action="noteList" method="post">
				标题：<input type="text" name="noteTitle"><br> <br>
				内容：
				<textarea rows="10" cols="20" name="NoteContent"></textarea>
				<br> <input type="submit" value="保存"> <input
					type="reset" value="取消">
			</form>
		</div>
		<br>${msg}
		<hr>
		<ul>
			<li><a href="noteDetails">笔记1</a></li>
			<li>笔记2</li>
			<li>笔记3</li>
			<li>...</li>
		</ul>
	</div>
	<%@ include file="../fragment/footer.jsp"%>
	<script type="text/javascript">
		function show() {
			document.getElementById("NoteDiv").style.display = "block";
		}
	</script>
</body>
</html>