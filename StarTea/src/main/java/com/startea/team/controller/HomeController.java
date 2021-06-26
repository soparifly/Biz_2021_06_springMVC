package com.startea.team.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.startea.team.service.CustomService;
import com.startea.team.service.EventService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class HomeController {

	protected final CustomService ctService;
	protected final EventService etService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		return "home";
	}

}
