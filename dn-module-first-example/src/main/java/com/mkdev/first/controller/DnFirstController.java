package com.mkdev.first.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-Jun-04 5:01:37 am 
 */
@RestController
@RequestMapping("/user")
public class DnFirstController {

	@GetMapping("/hello")
	public String callIndex(Model model) {
		return "hello world message from user module";
	}
}
