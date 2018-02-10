package ua.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BaseController {

	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/news")
	public String showNews(Model model) {
		List<String> newsList = new ArrayList<>();
		newsList.add("News-1");
		newsList.add("News-2");
		newsList.add("News-3");
		newsList.add("News-4");
		newsList.add("News-5");
		newsList.add("News-6");
		newsList.add("News-7");
		
		model.addAttribute("newsModel", newsList);
		return "news";
	}
	
	
	@GetMapping("/news/{postName}")
	public String showOneNews(Model model, @PathVariable("postName") String postName) {
		model.addAttribute("post", postName);
		return "news/post";
	}
}
