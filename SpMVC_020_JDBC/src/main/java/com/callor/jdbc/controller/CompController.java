package com.callor.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.service.CompService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/comp")

public class CompController {
	protected final CompService compService;
	protected final CompDao compDao;

	public CompController(CompDao compDao, CompService compService) {

		this.compService = compService;
		this.compDao = compDao;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String list() {
		log.debug("Company Root");
		return "comp/list";
	}

	// localhost:8080/jdbc/comp/insert로 호출되는 함
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		// Web-INF/views/comp/input.jsp를 열어라
		return "comp/input";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(CompVO cmVO) {
		log.debug("Company VO  {} ", cmVO.toString());
		compService.insert(cmVO);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	웹에서 지정했던 변수를 매개변수로 지정해준다
//	웹에서 받는 변수와 처리하는 변수가 다르게 사용하고싶다면 이렇게 사용한다
//	public String delete(@RequestParam("cp_code") String code) {
	public String delete(String cpcode) {
		compDao.delete(cpcode);
		return "redirect:/";
	}
}
