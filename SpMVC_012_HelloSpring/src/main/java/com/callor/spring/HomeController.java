package com.callor.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger("Home Controller");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// loger의 method들

		// 이 mehtod들을 logger에서는 level이라고 부른다
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.trace("트레이스");
		logger.debug("디버그");
		// 디버그까지 출력됨 
		logger.error("에러");
		logger.warn("워닝");
		logger.info("인포 welcome home!");
		logger.debug(String.valueOf(300 * 400));
		logger.debug(" 여기는 Home Controller 여기는 return 바로위");
		return "home";
	}

}
