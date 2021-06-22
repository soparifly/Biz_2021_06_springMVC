package com.callor.jdbc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.service.AuthorService;
import com.callor.jdbc.service.HomeService;
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
	@Value("${user.name}")
	protected String user_name;
//	@Value("${user.email}")
//	protected String user_email;
	
	protected final RentService rentService;
	protected final HomeService homeService;
	
	
	public HomeController(RentService rentService, HomeService homeService) {
		// TODO Auto-generated constructor stub
		this.homeService = homeService;
		this.rentService = rentService;
	}
/*
 * 사용자에게 Response를 할때
 * 
 * forward방법과 redirect방법이 있다
 * forwarding은 
 * service등등에서 생성(조회한)데이터를 
 * *.jsp 파일과 Rendering 하여 사용자에게 HTML코드로 전송한다
 * service등등에서 생성한 데이터는 Model 객체에 AddAtturibute()method를
 * 세팅하여 home,jsp에 출력한다 
 * 
 * 
 * Spring -> main ->  HomeController -> home ->   
 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		homeService.dashBoard(model);
		
		
		/*
		 * 매개변수로 전달 받은 Model class type 변수인 model에 속성을 하나 추가한다
		 * 속성의 이름은 user 이며 , 값은 user_name 에 담긴 값이다
		 * 
		 * Model 객체에 담긴 속성(변수)들은 jsp 파일과 Rendering 이 완료되면
		 * 메모리에서 삭제된다 
		 * 
		 */
		model.addAttribute("user", user_name);
		
		
		rentService.viewBookAndCompany();
		return "home";
	}

}
