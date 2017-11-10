package hellospring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.gson.Gson;

import hellospring.model.User;
import hellospring.service.interfaces.ArtComtService;

/**
 * 
 * @author Dream Sky 消息控制器，负责用户评论、系统通知等事务
 */
@Controller
public class MessageController {
	@Autowired
	Gson gson;

	@Autowired
	ArtComtService artComtService;

	/*
	 * 发表教程留言
	 */
	@RequestMapping(value = "/articleComt", method = RequestMethod.POST)
	public void ArtComment(@RequestParam("articleID") int articleID, @RequestParam("authorID") int authorID,
			@RequestParam("artcomtText") String artcomtText, HttpServletResponse response, HttpSession session)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("User");
		/* 判断用户的在线状态 */
		if (user == null) {
			out.print("offline");
			return;
		}
		out.print(artComtService.CreateComment((int) user.getUersID(), authorID, articleID, artcomtText));
	}

	/* 加载教程留言 */
	@RequestMapping(value = "/loadArtComments", method = RequestMethod.POST)
	public void loadArtComments(@RequestParam("articleID") int articleID, HttpServletResponse response)
			throws IOException {
		response.setContentType("application/json;charset=utf-8");
		String json = gson.toJson(artComtService.GetAtticleComments(articleID));
		response.getWriter().print(json);
	}
}
