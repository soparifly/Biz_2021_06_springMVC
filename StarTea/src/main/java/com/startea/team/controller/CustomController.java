package com.startea.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/custom")
public class CustomController {

	public String custom(Model model) {

		return "home";
	}

}
