/**
 * 登录和注册面板函数 Created by DreamSky on 2017/4/19.
 */
$(function() {
			var errorTip = $(".errorTip");
			if (errorTip.html().length == 0) {
				errorTip.css("display", "none");
			}
		});

/* 登录表单提交 */
function onLogin() {
	var UCount = $("#UCount").val();
	var PsWd = $("#PsWd").val();
	if (UCount.length == 0 || PsWd.length == 0) {
		alert('账号和密码不能为空');
		return;
	} else {
		$("#loginForm").submit();
	}
}