/*
 * 标识当前页码
 */
var pageIndex = 1;
var SumPage = 1;
var themeID = $("#themeID").html();
/* 网页就绪 */
$(function() {
			getArticleList();
			getSumpage();
		});
/* 获取总页码数 */
function getSumpage() {
	$.ajax({
				url : "SumPage",
				dataType : "text",
				type : "POST",
				cache : false,
				data : {
					"ThemeID" : themeID
				},
				success : function(data) {
					SumPage = data;
					/* 如果总页码数不为0则加载分页按钮 */
					if (data != 0)
						loadPageIndex();
				}
			});
}
/* 获取教程列表 */
function getArticleList() {
	$.ajax({
				url : "SimpleArtList",
				dataType : "json",
				type : "POST",
				cache : false,
				data : {
					"ThemeID" : themeID,
					"PageIndex" : pageIndex
				},
				success : function(data) {
					showArticleList(data);
				},
				error : function(data) {
					alert("加载失败,请刷新重试！");
				}

			});
}
/*
 * 显示教程列表到页面
 */
function showArticleList(data) {
	/* 教程列表容器 */
	var contentContainer = $(".contentContainer");
	/* 清空上一页的元素 */
	contentContainer.html("");
	if (data == null) {
		contentContainer.html($("#emptyTips").html());
		return;
	}

	/* 教程列表单元 */
	var artListCell = $(".artListCell");
	/* 查找需要修改的元素 */
	var artTheme = artListCell.find(".artTheme");
	var artTitle = artListCell.find(".artTitle");
	var artSummary = artListCell.find(".artSummary");
	var artTime = artListCell.find(".artTime");
	/* 填充属性 */
	$.each(data, function(i) {
				artTheme.html('[' + data[i].ThemeName + ']');
				artTitle.html(data[i].Title);
				artTitle.attr("href", "articleDetails" + data[i].ArticleID);
				artSummary.html(data[i].Summary);
				artTime.html(data[i].UpTime);
				contentContainer.append(artListCell.html());
			});
}
/* 加载教程分页按钮 */
function loadPageIndex() {
	/* 获取教程列表容器 */
	var pageIndexUl = $(".pageIndexUl");
	/* 添加上一页 */
	addPrePage(pageIndexUl);
	/* 页码按钮 */
	addPageBtn(pageIndexUl);
	/* 添加下一页 */
	addNextPage(pageIndexUl);
	ajustPageNava(pageIndexUl);
}
/* 创建上一页按钮 */
function addPrePage(ul) {
	var articleLi = $("<li><a></a></li>");
	var tagA = articleLi.find("a");
	tagA.html("上一页");
	articleLi.attr("id", "PrePage");
	/* 绑定点击事件 */
	tagA.click(function() {
				if (!hasPrePage())
					return;
				pageIndex--;
				getArticleList();
				/* 当前页值改变之后再判断一次是否有上下页 */
				ajustPageNava(ul);
			});
	/* 添加到页面 */
	ul.append(articleLi);
}

/* 创建下一页按钮 */
function addNextPage(ul) {
	var articleLi = $("<li><a></a></li>");
	var tagA = articleLi.find("a");
	tagA.html("下一页");
	articleLi.attr("id", "NextPage");
	/* 绑定点击事件 */
	tagA.click(function() {
				if (!hasNextPage())
					return;
				pageIndex++;
				getArticleList();
				ajustPageNava(ul);
			});
	ul.append(articleLi);
}
/* 判断是否有上一页 */
function hasPrePage() {
	if (pageIndex == 1) {
		$("#PrePage").addClass("disabled");
		return false;
	}
	$("#PrePage").removeClass("disabled");
	return true;
}
/* 判读是否有下一页 */
function hasNextPage() {
	if (pageIndex == SumPage.trim()) {
		$("#NextPage").addClass("disabled");
		return false;
	}
	$("#NextPage").removeClass("disabled");
	return true;
}
/* 创建页面按钮 */
function addPageBtn(ul) {
	for (var i = 1; i <= SumPage; i++) {
		var articleLi = $("<li><a></a></li>");
		articleLi.attr("id", i);
		var tagA = articleLi.find("a");
		tagA.html(i);
		tagA.click(function() {
					/* 将当前页设置为按钮上的页码 */
					pageIndex = $(this).html();
					/* 加载本页内容 */
					getArticleList();
					/* 判断上下页的情况 */
					ul.find("li").removeClass("active");
					ajustPageNava(ul);
				});
		ul.append(articleLi);
	}
}
/* 激活页码 */
function activePageIndex(ul) {
	ul.find("li").removeClass("active");
	/* 给当前页码加上active样式 */
	$("#" + pageIndex).addClass("active");
}
/* 调整分页导航栏：1.激活当前页2.判断是否有上下页 */
function ajustPageNava(ul) {
	activePageIndex(ul);
	hasPrePage();
	hasNextPage();
}