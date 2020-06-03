package com.mkdev.second.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-Jun-04 4:42:40 am 
 */
@RestController
@RequestMapping("/depart")
public class DnSecondController {

	@GetMapping("/hello")
	public String callIndex(Model model) {
		return "hello world message from department module";
	}
}
