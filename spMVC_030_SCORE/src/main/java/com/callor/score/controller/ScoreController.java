package com.callor.score.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.ScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/score")
public class ScoreController {

	protected final ScoreService scService;
	
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String home(Model model) {
		
		List<ScoreDTO> scList = scService.scoreAllList();
		
		log.debug("Service {} ", scList);

		model.addAttribute("SCORES",scList);
		model.addAttribute("BODY","SCORE_VIEW");
		return "home";
	}
}
