package hellospring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.gson.Gson;

import hellospring.model.User;
import hellospring.service.interfaces.ArticleService;

/**
 * 
 * @author Dream Sky 本控制器为教程文章控制器，处理与教程文章相关的业务逻辑
 */
@Controller
public class ArticleController {
	@Autowired
	ArticleService articleService;
	@Autowired
	Gson gson;

	/* 网站首页,加载教程列表 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String index() {
		return "home";
	}

	/* 按主题获取教程列表,用于网页顶部导航栏点击时将主题id传给home.jsp用于ajax判断换要加载的列表 */
	@RequestMapping(value = "/home{themeID}", method = RequestMethod.GET)
	public String articleListByTheme(@PathVariable("themeID") int themeID, Model model) {
		/* System.out.println("themeID" + themeID); */
		model.addAttribute("themeID", themeID);
		return "home";
	}

	/*
	 * 获取分页的总页码，若ThemeID为0则为不按主题分类下的总页码数 否则查找对应ThemeID分页下的总页码数
	 */
	@RequestMapping(value = "/SumPage", method = RequestMethod.POST)
	public void getSumPage(@RequestParam("ThemeID") int ThemeID, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		int sumPage;
		if (ThemeID == 0) {
			sumPage = articleService.PageSumOfArticle();
		} else {
			sumPage = articleService.PageSumByTheme(ThemeID);
		}
		response.getWriter().println(sumPage);
	}

	/*
	 * 获取简单教程列表
	 */
	@RequestMapping(value = "/SimpleArtList", method = RequestMethod.POST)
	public void getSimpleArtList(@RequestParam("ThemeID") int ThemeID, @RequestParam("PageIndex") int PageIndex,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		String json = gson.toJson(articleService.GetSimpleArtList(ThemeID, PageIndex));
		response.getWriter().println(json);
	}

	/*
	 * 单个教程文章详情
	 */
	@RequestMapping(value = { "/articleDetails", "/articleDetails{articleID}" }, method = RequestMethod.GET)
	public String articleDetails(@PathVariable("articleID") int articleID, Model model) {
		model.addAttribute("article", articleService.FindByID(articleID));
		return "articles/articleDetails";
	}

	/*
	 * 单个教程文章详情的POST方式
	 */
	@RequestMapping(value = "/articleDetails", method = RequestMethod.POST)
	public void articleDetailsPost(@RequestParam("articleID") int articleID, HttpServletResponse response)
			throws IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(articleService.FindByID(articleID)));
	}

	/*
	 * 教程管理页面请求
	 */
	@RequestMapping(value = "/articleManage", method = RequestMethod.GET)
	public String ArticleMangePage(Model model) {
		return "articles/articleManage";
	}

	/*
	 * 教程删除 根据教程ID删除指定的教程记录,判断session中用户类型为Manger才可以删除教程,若Session为空则拒绝删除
	 */
	@RequestMapping(value = "/articleDelete", method = RequestMethod.POST)
	public void ArticleDelete(@RequestParam("articleID") int articleID, HttpServletResponse response,
			HttpSession session) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("User");
		if (user == null) {
			out.print("offline");
		}
		out.println(articleService.DeleteArticle(articleID));
	}

	/*
	 * 创建教程文章
	 */
	@RequestMapping(value = "/createArticle", method = RequestMethod.POST)
	public void CreateArticle(@RequestParam("ArtTitle") String ArtTitle, @RequestParam("ArtThemeID") int ArtThemeID,
			@RequestParam("ArtSummary") String ArtSummary, @RequestParam("ArtContent") String ArtContent,
			HttpSession session, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		// System.out.println(ArtContent);
		User user = (User) session.getAttribute("User");
		if (user == null) {
			response.getWriter().println("offline");
			return;
		}
		response.getWriter().println(
				articleService.CreateArticle((int) user.getUersID(), ArtThemeID, ArtTitle, ArtSummary, ArtContent));
	}

	/*
	 * 教程编辑页面请求,{articleID}为0时表示新建教程，否则为编辑对应id的教程
	 */
	@RequestMapping(value = "/articleEdit{articleID}", method = RequestMethod.GET)
	public String ArticleEditPage(@PathVariable("articleID") int articleID, Model model) {
		model.addAttribute("articleID", articleID);
		return "articles/articleEdit";
	}

	/*
	 * 教程编辑处理控制器
	 */
	@RequestMapping(value = "/articleEdit", method = RequestMethod.POST)
	public void ArticleEdit(@RequestParam("ArtTitleID") int ArtTitleID, @RequestParam("ArtTitle") String ArtTitle,
			@RequestParam("ArtThemeID") int ArtThemeID, @RequestParam("ArtSummary") String ArtSummary,
			@RequestParam("ArtContent") String ArtContent, HttpSession session, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("User");
		if (user == null) {
			out.println("offline");
		} else {
			out.print(articleService.Articlemodify(ArtTitleID, ArtThemeID, ArtTitle, ArtSummary, ArtContent));
		}
		out.flush();
		out.close();
	}

	/* 获取教程主题列表 */
	@RequestMapping(value = "/themeList", method = RequestMethod.POST)
	public void getThemeList(HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		String json = gson.toJson(articleService.ArtThemeList());
		response.getWriter().println(json);
	}

	/* summernote文本输入框测试 */
	@RequestMapping(value = "/summerNote", method = RequestMethod.POST)
	public void articleEidt(@RequestParam("content") String txt, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(txt);
		response.getWriter().flush();
		response.getWriter().close();
	}
}
