/**
 * 
 */
$(function() {
			$("#ImgFileInput").change(function() {
						$("#imgPreView").attr("src",
								getObjectURL(this.files[0]));
					});

		});
/* 用户信息表提交 */
function onUserInfoSumbit() {
	userInfoSumbit($("#ImgFileInput")[0].files[0]);

}
// 建立一個可存取到該file的url
function getObjectURL(file) {
	var url = null;
	if (window.createObjectURL != undefined) {
		// basic
		url = window.createObjectURL(file);
	} else if (window.URL != undefined) {
		// mozilla(firefox)
		url = window.URL.createObjectURL(file);
	} else if (window.webkitURL != undefined) {
		// webkit or chrome
		url = window.webkitURL.createObjectURL(file);
	}
	return url;
}
/* 头像上传 */
function userInfoSumbit(file) {
	/* 如果头像文件为空则直接提交用户基本信息而不提交头像 */
	if (file == null) {
		$("#userInfoForm").submit();
		return;
	}
	var data = new FormData();
	/* 将全部图片文件添加到data */
	data.append("ajaxTaskFile", file);
	/* 异步文件上传 */
	$.ajax({
				data : data,
				type : "POST",
				url : "userImgUpload",
				/* 图片上传出来的url，返回的是图片上传后的路径，http格式 */
				cache : false,
				contentType : false,
				processData : false,
				dataType : "text",
				success : function(data) {
					if (data.trim() == "offline") {
						alert("登录失效，请重新登录！");
						window.location.href = "login";
					} else if (data.trim() == "true") {
						alert("修改成功！");
						/* 头像修改成功后上传用户信息 */
						$("#userInfoForm").submit();
					} else {
						alert("头像修改失败，请重试！");
					}

				},
				error : function(data) {
					alert("上传失败");
				}
			});

}