package com.startea.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/event")
public class EventController {

	public String event(Model model) {

		return "home";

	}
}
