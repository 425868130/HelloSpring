package hellospring.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Dream Sky 用户学习笔记控制器
 */
@Controller
public class NotesController {
	/*
	 * 请求笔记列表页面
	 */
	@RequestMapping(value = "/noteList", method = RequestMethod.GET)
	public String NoteListPage(Model model) {
		return "notes/noteList";
	}

	/*
	 * 创建笔记
	 */
	@RequestMapping(value = "/noteList", method = RequestMethod.POST)
	public String CreateNote(@RequestParam("noteTitle") String noteTitle,
			@RequestParam("NoteContent") String NoteContent, Model model, HttpSession httpSession) {
		model.addAttribute("msg", "笔记创建成功！");
		return "notes/noteList";
	}

	/*
	 * 笔记详情页
	 */
	@RequestMapping(value = "/noteDetails", method = RequestMethod.GET)
	public String noteDetailsPage(Model model) {
		return "notes/noteDetails";
	}

	/*
	 * 笔记编辑
	 */
	@RequestMapping(value = "/noteDetails", method = RequestMethod.POST)
	public String EditNote(@RequestParam("newTitle") String newTitle, @RequestParam("newContent") String newContent,
			Model model) {
		return "notes/noteDetails";
	}
	/*
	 * 删除笔记
	 */
}
