package com.example.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class TestController {

	@Autowired
	UserService userService;

	@GetMapping("/register")
	public String second(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String createUser(@ModelAttribute User user) {
		userService.create(user);
		return "redirect:/user/list";
	}

	@GetMapping("/list")
	public String first(Model model) {
		Collection<User> users = this.userService.getAll();
		model.addAttribute("users", users);
		return "list";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") int id) {
		this.userService.deleteUser(id);
		return "redirect:/user/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		User user = this.userService.getUserById(id);
		model.addAttribute("user",user);
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String editDetails(@PathVariable("id") int id, @ModelAttribute User user) {
		this.userService.editUser(id, user);
		return "redirect:/user/list";
	}
	
	

}
