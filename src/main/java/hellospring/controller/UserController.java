package hellospring.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hellospring.model.User;
import hellospring.service.interfaces.UserService;

/**
 * 
 * @author Dream Sky 用户控制器，负责用户信息、登录注销等事务
 */
@Controller
public class UserController {
	@Autowired
	UserService userService;

	/*
	 * 请求登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginPage() {
		return "users/login";
	}

	/*
	 * 登录操作
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(@RequestParam("UCount") String UCount, @RequestParam("PsWd") String Pswd, Model model,
			HttpSession httpSession) {
		if (userService.Login(UCount, Pswd, httpSession)) {
			return "home";
		} else {
			model.addAttribute("msg", "登录失败,用户名或密码错误!");
			return "users/login";
		}
	}

	/**
	 * 请求注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userReg", method = RequestMethod.GET)
	public String UserRegPage() {
		return "users/userReg";
	}

	/**
	 * 注册操作
	 */
	@RequestMapping(value = "/userReg", method = RequestMethod.POST)
	public String UserReg(@RequestParam("UCount") String UCount, @RequestParam("PsWd") String Pswd,
			@RequestParam("PswdConfirm") String PswdConfirm, @RequestParam("Email") String Email, Model model) {
		if (UCount.length() == 0 || Pswd.length() == 0 || PswdConfirm.length() == 0 || Email.length() == 0) {
			model.addAttribute("msg", "所有输入项均 不能为空");
		} else if (!Pswd.equals(PswdConfirm)) {
			model.addAttribute("msg", "两次密码不相同！");
		} else if (userService.findByCount(UCount) != null) {
			model.addAttribute("msg", "账号已存在,请直接登录！");
		} else if (userService.UserReg(UCount, Pswd, Email)) {
			model.addAttribute("msg", "注册成功！");
		} else {
			model.addAttribute("msg", "注册失败！");
		}
		return "users/userReg";
	}

	/**
	 * 注销操作
	 */
	@RequestMapping("/logout")
	public String Logout(HttpSession httpSession) {
		userService.Logout(httpSession);
		return "home";
	}

	/**
	 * 用户信息详情页
	 */
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String UserInfoPage(Model model, HttpSession session) {
		model.addAttribute("user", (User) session.getAttribute("User"));
		return "users/userInfo";
	}

	/**
	 * 用户信息修改
	 */
	@RequestMapping(value = "/userInfoChange", method = RequestMethod.POST)
	public String userInfoChange(@RequestParam("nickName") String nickName, @RequestParam("Email") String Email,
			@RequestParam("sign") String sign, @RequestParam("sex") int sex, Model model, HttpSession session) {
		try {
			/* 转码为utf8防止中文乱码 */
			nickName = new String(nickName.getBytes("ISO-8859-1"), "UTF-8");
			sign = new String(sign.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* 若用户未登录则返回登录页面 */
		User loginUser = (User) session.getAttribute("User");
		if (loginUser == null) {
			return "users/login";
		}

		userService.UserInfoChange(loginUser.getUCount(), nickName, sex, sign, Email);
		/* 刷新Session中的用户数据 */
		loginUser = userService.findByCount(loginUser.getUCount());
		session.setAttribute("User", loginUser);
		model.addAttribute("user", loginUser);
		return "users/userInfo";
	}
}
