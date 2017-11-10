/**
 * 
 */
/* 加载教程留言 */
function loadArtComment(articleID) {
	$.ajax({
				url : "loadArtComments",
				dataType : "json",
				type : "POST",
				data : {
					"articleID" : articleID
				},
				success : function(data) {
					showComments(data);
				},
				error : function(data) {
					alert("留言加载失败！");
				}
			});
}
/*加载留言列表*/
function showComments(data) {
	/* 留言列表容器 */
	var commentList = $('.commentList');
	/* 先清空留言 */
	commentList.html("");
	/* 构造DOM元素 */
	var $CommentLiDOM = $("<div><li><span class='cmtUserNicke'></span><br><span class='commentText'></span><br><span class='commentTime'></span><hr></li></div>");
	var userNick = $CommentLiDOM.find(".cmtUserNicke");
	var commentText = $CommentLiDOM.find(".commentText");
	var commentTime = $CommentLiDOM.find(".commentTime");
	$.each(data, function(i) {
				userNick.html(data[i].SenderNick + " :");
				commentText.html(data[i].MsgContent);
				commentTime.html(data[i].MsgTime);
				commentList.append($CommentLiDOM.html());
			});
}
/* 发送留言 */
function SendComment(articleID) {
	var commtText = $(".commentInput").val();
	var articleAuthor = $(".articleAuthor").val();
	$.ajax({
				url : "articleComt",
				type : "POST",
				dataType : "text",
				data : {
					"articleID" : articleID,
					"authorID" : articleAuthor,
					"artcomtText" : commtText
				},
				success : function(data) {
					if (data == 'offline') {
						alert("要留言,请先登录!");
					} else if (data == 'true') {
						/* 留言成功清空输入框 */
						$(".commentInput").val("");
						alert("留言已发送!");
						/* 重新加载留言列表 */
						loadArtComment(articleID);
					} else {
						alert("留言失败,请重新发送");
					}
				},
				error : function(data) {
					alert("留言失败,请重新发送");
				}
			});

}