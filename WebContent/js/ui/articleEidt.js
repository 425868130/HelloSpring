var articleID = $("#pageFlag").html();

$(function() {
			getThemeList();
			InitSummerNote();
			/* 如果articleID不为0则为教程编辑，此时加载教程详情 */
			if (articleID != 0) {
				loadArticle();
			}
		});

/* 初始化编辑器 */
function InitSummerNote() {
	$('#summerNote').summernote({
				lang : 'zh-CN',
				height : 400,
				minHeight : 400,
				placeholder : '编写教程. . .',
				airPopover : [['color', ['color']],

						['font', ['bold', 'underline', 'clear']],

						['para', ['ul', 'paragraph']],

						['table', ['table']],

						['insert', ['picture']]

				],
				callbacks : {
					onImageUpload : function(files) {
						sendFile(files);
					}
				}

			});
}
/* 上传图片到服务器 */
function sendFile(files) {
	var data = new FormData();
	/* 将全部图片文件添加到data */
	$.each(files, function(i) {
				data.append("ajaxTaskFile", files[i]);
			});
	/* 异步文件上传 */
	$.ajax({
				data : data,
				type : "POST",
				url : "imgUpload", // 图片上传出来的url，返回的是图片上传后的路径，http格式
				cache : false,
				contentType : false,
				processData : false,
				dataType : "json",
				success : function(data) {// data是返回的hash,key之类的值，key是定义的文件名
					var re = eval(data);
					var editable = $('#summerNote');
					$.each(re, function(i) {
								editable.summernote('insertImage', re[i]);
							});

				},
				error : function(data) {
					alert("上传失败");
				}
			});
}
/* 提交按钮的点击事件 */
function submitArticle() {
	if (articleID == 0) {
		onArticleCreate();
	} else {
		onArticleUpdate();
	}
}
/* 清空所有输入框 */
function clearAll() {
	$("#summerNote").summernote('code', "");
	$("#inputArtTitle").val("");
	$("#articleSummary").val("");
}
/* 新建教程 */
function onArticleCreate() {
	var content = $("#summerNote").summernote('code');
	var themeID = $("#themeSelect").val();
	var artTitle = $("#inputArtTitle").val();
	var articleSummary = $("#articleSummary").val();

	if (artTitle.length == 0 || articleSummary.length == 0
			|| $("#summerNote").summernote('isEmpty')) {
		alert("请填写完整教程信息!");
		return;
	}
	$.ajax({
				url : "createArticle",
				type : "POST",
				dataType : "html",
				data : {
					"ArtTitle" : artTitle,
					"ArtThemeID" : themeID,
					"ArtSummary" : articleSummary,
					"ArtContent" : content
				},
				success : function(data) {
					if (data.trim() == "offline") {
						alert("登录失效,请重新登录!");
						return;
					} else if (data.trim() == "true") {
						alert("教程创建成功!");
						clearAll();
					} else {
						alert("创建失败,请重试!");
					}
				}
			});
}
/* 教程编辑修改 */
function onArticleUpdate() {
	var content = $("#summerNote").summernote('code');
	var themeID = $("#themeSelect").val();
	var artTitle = $("#inputArtTitle").val();
	var articleSummary = $("#articleSummary").val();
	$.post("articleEdit", {
				"ArtTitleID" : articleID,
				"ArtTitle" : artTitle,
				"ArtThemeID" : themeID,
				"ArtSummary" : articleSummary,
				"ArtContent" : content
			}, function(data) {
				if (data.trim() == "offline") {
					alert("登录失效,请重新登录!");
					return;
				} else if (data.trim() == "true") {
					alert("教程已更新!");
				} else {
					alert("创建失败,请重试!");
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
					loadThemeToSelect(data);
				}
			});
}

/* 将主题列表添加到下拉选择框 */
function loadThemeToSelect(data) {
	var themeSelect = $("#themeSelect");
	themeSelect.html("");
	var $selectItem = $("<div><option></option></div>");
	var option = $selectItem.find("option");
	$.each(data, function(i) {
				option.val(data[i].ThemeID);
				option.html(data[i].TName);
				themeSelect.append($selectItem.html());
			});

}
/* 加载教程内容到编辑区 */
function loadArticle() {
	var content = $("#summerNote");
	var themeID = $("#themeSelect");
	var artTitle = $("#inputArtTitle");
	var articleSummary = $("#articleSummary");
	$.post("articleDetails", {
				"articleID" : articleID
			}, function(data) {
				if (data == null) {
					alert("教程加载失败,请刷新重试!");
				} else {
					content.summernote('code', data.Content);
					themeID.val(data.ThemeID);
					artTitle.val(data.Title);
					articleSummary.val(data.Summary);
				}
			});
}