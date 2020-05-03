package com.mkdev.example.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkdev.example.model.DnUser;
import com.mkdev.example.service.DnUserConsumeService;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-May-03 9:53:10 pm
 */
@Controller
public class DnUserConsumeController {

	@Autowired
	DnUserConsumeService service;

	@Value("${welcome.message}")
	private String title;

	@GetMapping("/")
	public String welcome(Model model) {

		// model.addAttribute("user", service.getUser());
		model.addAttribute("title", title);
		model.addAttribute("message", "Hello Thymeleaf Template");

		return "welcome";
	}

	@GetMapping("/users")
	public String getUsers(Model model) {

		model.addAttribute("userList", service.getUserList());
		model.addAttribute("title", "Users List");
		model.addAttribute("message", "List of Users from Service");

		return "users/userList";
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String editUser(Model model, @PathVariable("id") Optional<Long> id) {

		if (id.isPresent()) {
			DnUser entity = service.getUser(id.get());
			model.addAttribute("user", entity);
		} else {
			model.addAttribute("user", new DnUser());
		}
		model.addAttribute("title", "edit User");
		model.addAttribute("message", "");

		return "users/add-edit-user";
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String createOrUpdateCategory(DnUser user) {
		service.createOrUpdateUser(user);
		return "redirect:/users";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteUserById(Model model, @PathVariable("id") Optional<Long> id) {

		log.info("User Id" + id);

		if (id.isPresent()) {
			service.deleteUser(id.get());
		}

		return "redirect:/users";
	}

	private static final Log log = LogFactory.getLog(DnUserConsumeController.class);

}
