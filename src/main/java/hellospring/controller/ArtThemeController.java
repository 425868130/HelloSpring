package hellospring.controller;
/**
 * 教程主题控制器
 * @author DreamSky
 *
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hellospring.model.User;
import hellospring.service.interfaces.ArtThemeService;

@Controller
public class ArtThemeController {
	@Autowired
	ArtThemeService artThemeService;

	/* 删除主题 */
	@RequestMapping(value = "/deleteTheme", method = RequestMethod.POST)
	public void DeleteTheme(@RequestParam("themeID") int themeID, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(artThemeService.DeleteTheme(themeID));
	}

	/* 创建主题 */
	@RequestMapping(value = "/createTheme", method = RequestMethod.POST)
	public void createTheme(@RequestParam("themeName") String themeName, HttpSession session,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("User");
		if (user == null) {
			out.print("offline");
			return;
		}
		out.print(artThemeService.AddTheme((int) user.getUersID(), themeName));
	}

	/* 主题修改 */
	@RequestMapping(value = "/updateThemeName", method = RequestMethod.POST)
	public void updateThemeName(@RequestParam("themeID") int themeID, @RequestParam("themeName") String themeName,
			HttpServletResponse response, HttpSession session) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("User");
		if (user == null) {
			out.print("offline");
			return;
		}
		out.print(artThemeService.UpdateTheme(themeID, themeName));
	}
}
