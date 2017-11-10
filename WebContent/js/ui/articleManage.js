/**
 * 教程管理页的js
 */
$(function() {
			getThemeList();
			getArticleList(0);
		});

/* 获取教程列表 */
function getArticleList(themeID) {
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
/* 获取主题列表 */
function getThemeList() {
	$.ajax({
				url : "themeList",
				type : "POST",
				dataType : "json",
				success : function(data) {
					loadThemeToLeftDIV(data);
					loadThemeToSelect(data);
				}
			});
}
/* 将主题列表加载到左侧面板 */
function loadThemeToLeftDIV(data) {
	var themeListUL = $("#themeListUL");
	themeListUL.html("");
	/* 获取网页中预设的隐藏单元 */
	var themeLiDIV = $("#themeLiDIV");
	var themeName = themeLiDIV.find(".themeName");
	var themeID = themeLiDIV.find(".themeID");
	$.each(data, function(i) {
				themeName.html(data[i].TName);
				themeID.html(data[i].ThemeID);
				themeListUL.append(themeLiDIV.html());
			});
}
/* 将主题列表添加到下拉选择框 */
function loadThemeToSelect(data) {
	var selectTheme = $("#selectTheme");
	selectTheme.html("");
	var $selectItem = $("<div><option></option></div>");
	var option = $selectItem.find("option");
	$.each(data, function(i) {
				option.val(data[i].ThemeID);
				option.html(data[i].TName);
				selectTheme.append($selectItem.html());
			});

}
function onThemeDelete(obj) {
	var themeID = $(obj).parent().prev(".themeID").html();
	if (themeID == 0) {
		alert("默认主题不能删除!");
		return;
	}
	if (confirm("确定要删除该主题吗?操作不可逆!")) {
		/* 发送删除请求 */
		$.post("deleteTheme", {
					"themeID" : themeID
				}, function(data) {
					if (data.trim() == "true") {
						alert("删除成功！");
						getThemeList();
					} else {
						alert("删除失败！");
					}
				});
	}
}
/* 点击教程编辑按钮 */
function onArticleEdit(obj) {
	var articleID = $(obj).parent().prev(".articleID").html();
	location.href = "articleEdit" + articleID;
}
/* 点击教程删除按钮 */
function onArticleDelete(obj) {
	var articleID = $(obj).parent().prev(".articleID").html();
	if (confirm("删除操作不可逆,确认操作?")) {
		$.post("articleDelete", {
					"articleID" : articleID
				}, function(data) {
					if (data.trim() == "offline") {
						alert("登录失效,请重新登录!");
						return;
					} else if (data.trim() == "true") {
						alert("教程已删除!");
						/* 删除完成后重新加载教程列表 */
						getArticleList($("#selectTheme").val());
					} else {
						alert("删除失败");
					}
				});
	}
}

/* 获取教程列表 */
function getArticleList(themeID) {
	$.ajax({
				url : "SimpleArtList",
				dataType : "json",
				type : "POST",
				cache : false,
				data : {
					"ThemeID" : themeID,
					"PageIndex" : 1
				},
				success : function(data) {
					showArticleList(data);
				},
				error : function(data) {
					alert("加载失败,请刷新重试！");
				}

			});
}
/* 加载教程列表到页面 */
function showArticleList(data) {
	var articleListUL = $("#articleListUL");
	articleListUL.html("");
	if (data == null) {
		articleListUL.html("暂时没有教程哦");
		return;
	}
	var articleLiDIV = $("#articleLiDIV");
	var articleTitle = articleLiDIV.find(".articleTitle");
	var articleID = articleLiDIV.find(".articleID");
	$.each(data, function(i) {
				articleTitle.html(data[i].Title);
				articleTitle.attr("href", "articleDetails" + data[i].ArticleID);
				articleID.html(data[i].ArticleID);
				articleListUL.append(articleLiDIV.html());
			});
}
/* 下拉选框值变化时 */
function onThemeSelect(obj) {
	/* 获取选择框的教程主题值,通过该值加载教程列表 */
	getArticleList($(obj).val());
}
/* 主题添加按钮的点击事件 */
function addThemeBtnClick() {
	/* 先删除可能存在的输入框 */
	$("#themeCreateList").find(".themeInputLi").remove();
	/* 再追加新输入框,防止用户一直点击添加按钮一直在页面创建输入框的情况 */
	$("#themeCreateList").prepend($("#themeInputCell").html())
}

/* 教程主题编辑按钮点击事件 */
function onThemeEdit(obj) {
	/* 获取主题ID */
	var themeID = $(obj).parent().prev(".themeID").html();
	/* 获取主题输入框的页面元素 */
	var themeInputLi = $("#themeInputCell").find("li");
	/* 获取当前点击的列表元素 */
	var thisLiCell = $(obj).parent().parent();
	/* 获取主题名称放入输入框，然后隐藏当前主题名 */
	var themeName = thisLiCell.find(".themeName").html();
	thisLiCell.find(".themeName").css("display", "none");
	/* 移除当前列表的hoverList,可以禁用划入动画和浮动按钮的显示 */
	thisLiCell.removeClass("hoverList");
	/* 添加主题编辑输入框的样式 */
	thisLiCell.addClass("themeInputLi");
	/* 将主题输入框的页面元素添加到当前列表中 */
	thisLiCell.prepend(themeInputLi.html());
	/* 将主题名称设置到输入框 */
	thisLiCell.find("input").val(themeName);

}
/* 主题输入框确认按钮点击事件 */
function onThemeInputBtnOK(obj) {
	/*
	 * 获取列表对象 输入框点击确定按钮时有两种情况： 1.输入框在主题列表中 2.输入框在新建主题列表中
	 * 两种情况通过判断列表中是否有themeID的span元素可以获知，如果没有找到说明当前输入框在新增主题列表中，则调用创建主题操作
	 */
	var themeID = $(obj).parent().parent().find(".themeID");
	if (themeID.length == 0) {
		onThemeCreate(obj);
	} else {
		onThemeUpdate(obj, themeID.html());
	}
}
/* 主题输入框取消按钮点击事件 */
function onThemeInputCancle(obj) {
	var parentLi = $(obj).parent().parent();
	/* 判断当前取消按钮所属的li元素的类名，如果为themeInputLi说明在新建主题列表 */
	if (parentLi.attr("class") == "themeInputLi") {
		/* 在新建主题列表则直接删除当前列表 */
		parentLi.remove();
	} else {
		/* 在主题列表则恢复原来的样式，然后移除输入框 */
		parentLi.removeClass("themeInputLi");
		parentLi.addClass("hoverList");
		parentLi.find(".themeInputDIV").remove();
		parentLi.find(".themeName").css("display", "inline");
	}
}

/* 创建主题操作 */
function onThemeCreate(obj) {
	var themeInputVal = $(obj).prev(".themeInput").val();
	if (!themeNameCheck(themeInputVal)) {
		return;
	}
	/* 发送新建主题名到服务器 */
	$.post("createTheme", {
				"themeName" : themeInputVal
			}, function(data) {
				if (data == 'offline') {
					alert('登录超时,请重新登录后操作!');
					return;
				} else if (data == 'true') {
					alert('主题创建成功');
					/* 主题创建成功后移除输入框，重新加载主题列表 */
					onThemeInputCancle(obj);
					getThemeList();
				} else {
					alert('主题创建失败,请检查是否重名!');
				}
			});
}
/* 主题修改操作 */
function onThemeUpdate(obj, themeID) {
	var parentLi = $(obj).parent().parent();
	var themeInputVal = $(obj).prev(".themeInput").val();
	if (!themeNameCheck(themeInputVal)) {
		return;
	}
	if (themeID == 0) {
		alert("默认主题不能修改!");
		return;
	}
	/* 与修改前的主题名进行比较, 如果相同则不修改,相当于点击了取消按钮 */
	if (themeInputVal.trim() == parentLi.find(".themeName").html().trim()) {
		onThemeInputCancle(obj);
		return;
	}
	/* 校验通过则发送修改请求 */
	$.post("updateThemeName", {
				"themeID" : themeID,
				"themeName" : themeInputVal
			}, function(data) {
				if (data == 'offline') {
					alert('登录超时,请重新登录后操作!');
					return;
				} else if (data == 'true') {
					alert('主题修改成功');
					/* 主题修改成功后移除输入框，重新加载主题列表 */
					onThemeInputCancle(obj);
					getThemeList();
				} else {
					alert('主题修改失败,请检查是否重名!');
				}
			});
}
/* 主题名长度判断 */
function themeNameCheck(themeName) {
	if (themeName.length == 0) {
		alert("主题名不能为空!");
		return false;
	} else if (themeName.length > 20) {
		alert("主题名过长,请控制在20字以内!");
		return false;
	}
	return true;
}