package ua.online.course.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.online.course.entity.Role;
import ua.online.course.entity.User;
import ua.online.course.service.CourseService;
import ua.online.course.service.UserService;

@Controller
public class BaseController {

	private static final Logger logger = Logger.getLogger(BaseController.class);
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String showHome(Model model) {
		logger.info("INFO: show home page");
		model.addAttribute("title", "Home page");
		return "home";
	}
	
	@RequestMapping("/login")
	public String showLogin(Model model) {
		logger.info("INFO: show login page");
		model.addAttribute("title", "Login page");
		
		return "login";
	}
	
	@RequestMapping("/register")
	public String showRegister(Model model) {
		logger.info("INFO: show login page");
		model.addAttribute("title", "Register page");
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(
			@RequestParam("email") String email,
			@RequestParam("login") String login,
			@RequestParam("role") String role,
			@RequestParam("password") String password) {
		
		User user = new User(login, password, email);
		if(role.equals("TEACHER")) {
			user.setUserRole(Role.ROLE_TEACHER);
		} else if(role.equals("STUDENT")) {
			user.setUserRole(Role.ROLE_STUDENT);
		}
		
		logger.info("To Register: [login=" + login + ", email= " + email + ", role= " + role + ", password=" + password + "]");
		userService.save(user);
		logger.info("User: " + user);
		
		return "redirect:/login";
	}
	
//	/* TEST REST */
//	@RequestMapping("/testRest")
//	@ResponseBody
//	public String answer() {
//		return "HELLO";
//	}
	
	
}
