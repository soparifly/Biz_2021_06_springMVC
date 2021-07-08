package com.team.starbucks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.starbucks.model.CategoryDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/custom")
public class CustomController{

	protected final CategoryDTO cateDao;
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String costums() {
		log.debug("Custom root");
		return "custom/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		
//		List<CategoryDTO> cateList1 = cateDao.setMenu_code(null);
			
		cateDao.getMenu_kinds();
		
		return "custom/input";
	}
}
