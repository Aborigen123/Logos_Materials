package ua.online.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.online.course.service.CourseService;

@Controller
public class BaseController {

	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("title", "Home page");
		return "home";
	}
}
