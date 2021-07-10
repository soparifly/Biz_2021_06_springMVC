package com.team.starbucks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.starbucks.model.CategoryDTO;
import com.team.starbucks.model.CategoryVO;
import com.team.starbucks.model.CustomDTO;
import com.team.starbucks.model.CustomVO;
import com.team.starbucks.model.UserVO;
import com.team.starbucks.service.CustomService;
import com.team.starbucks.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/custom")
public class CustomController{

	@Qualifier("customServiceV1")
	protected final CustomService cuService;
	@Qualifier("fileServiceV1")
	protected final FileService fService;
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String list(HttpSession session, Model model, CustomVO customVO) {
		
		 UserVO userVO = (UserVO) session.getAttribute("USER");
		 List<CustomDTO> cuList = cuService.selectAll();
		 
		log.debug("Custom root");
		
		return "custom/list";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String insert(@RequestParam("menukinds")int menu_kinds,Model model) {
		
			List<CategoryDTO> menukindsList = cuService.findByMenukinds(menu_kinds);
			log.debug("munukindsList {}",menukindsList.toString());
			model.addAttribute("KINDS", menukindsList);
			
		return "custom/input";
	}
}
