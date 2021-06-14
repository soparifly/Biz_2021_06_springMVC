package com.callor.jdbc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.service.RentService;

import lombok.extern.slf4j.Slf4j;

/*
 * @Autowired
 * private BookDao bookdao;
 *  이코드에서 메모리 leak(누수)현상이 보고되어 다음의 코드를 권장한다
 */

@Slf4j
@Controller
public class HomeController {
	//SpMVC_020_JDBC/src/main/webapp/WEB-INF/spring/config/string.properties 네서 설정된 속성값을 가져와서 변수에 setting
//	@Value("${user.name")
//	protected String username;
//	@Value("${user.email")
//	protected String user_email;
	
//	protected final BookDao bookDao;
	protected final RentService rentService;
	public HomeController(RentService rentService) {
		// TODO Auto-generated constructor stub
		this.rentService = rentService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		log.debug("UserName : {}" , user_name);
//		log.debug("User Email : {}" , user_email)
		
		rentService.viewBookAndCompany();
		return "home";
	}

}
