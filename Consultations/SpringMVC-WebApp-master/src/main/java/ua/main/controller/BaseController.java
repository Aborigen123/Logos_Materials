package ua.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BaseController {

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// @RequestMapping("/")
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/friends")
	public String showFriends(Model model) {
		String title = "Friends page title";
		model.addAttribute("title", title);
		
		List<String> friends = new ArrayList<>();
		friends.add("Monika");
		friends.add("Reichal");
		friends.add("Chandler");
		friends.add("Joi");
		friends.add("Rose");
		friends.add("Phoebi");
		
		model.addAttribute("friendsList", friends);
		
		return "friends";
	}
	
	@GetMapping("/profile/{friendName}")
	public String showFriedProfile(
			@PathVariable("friendName") String friendName, Model model) {
		
		model.addAttribute("friend", friendName);
		return "friends/profile";
	}
}
