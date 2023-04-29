package edu.itstep.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.itstep.albums.dao.User;
import edu.itstep.albums.dao.UserRepository;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/signup")
	public String signUpForm(User user) {
		return "add-user";
	}

	@GetMapping("/")
	public String showUserList(Model model) {

		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/login")
	public String log(Model model) {

		return "login";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		userRepository.save(user);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) throws Exception {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
		userRepository.delete(user);
		return "redirect:/";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index";
		}
		userRepository.save(user);
		return "index";
	}
}
