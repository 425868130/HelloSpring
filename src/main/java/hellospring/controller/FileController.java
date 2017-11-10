package hellospring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import hellospring.model.User;
import hellospring.service.interfaces.FileService;
import hellospring.service.interfaces.UserService;

@Controller
public class FileController {
	@Autowired
	FileService fileService;
	@Autowired
	UserService userService;
	@Autowired
	Gson gson;

	public final static String FilePath = "/upload/";
	public final static String userImgPath = "/upload/userImg/";

	/* 用于处理图片文件的上传 */
	@RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
	public void ImgUpload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FileUpload");
		response.setContentType("application/json;charset=UTF-8");
		String Urls = gson.toJson(fileService.fileUpload(request, FilePath));
		System.out.println(Urls);
		response.getWriter().println(Urls);
		response.getWriter().flush();
		response.getWriter().close();
	}

	/* 用于处理用户头像图片文件的上传 */
	@RequestMapping(value = "/userImgUpload", method = RequestMethod.POST)
	public void userImgUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		System.out.println("FileUpload");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("User");
		if (user == null) {
			out.print("offline");
			return;
		}
		String savePath = fileService.fileUpload(request, userImgPath).get(0);
		if (savePath == null || savePath.length() == 0) {
			return;
		}
		if (userService.UpdateUserImg(user.getUCount(), savePath)) {
			out.print("true");
		} else {
			out.print("false");
		}
	}
}
