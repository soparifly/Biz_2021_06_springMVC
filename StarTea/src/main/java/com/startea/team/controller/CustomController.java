package com.startea.team.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.startea.team.model.CustomVO;
import com.startea.team.service.CustomService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/custom")
public class CustomController {

	protected final CustomService ctService;
	public String custom(Model model) { 
		List<CustomVO> ctList = ctService.selectAll();
		model.addAttribute("KINDS", ctList);
		return "home";
	}

}
