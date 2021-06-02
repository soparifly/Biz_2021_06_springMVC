package com.callor.hello.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.serivce.HomeService;
/*
 *  * HomeController 에서 Serivce를 사용하려면 protected 로 선언하고 생성자에서 new를 이용해 초기화 해줬었다.
 * 이것은 전통적인 Java 코드에서 HomeService 클래스를 객체로 선언하여 사용하는 방법이었다.
 * 
 * 스프링에서 선언하는방법 
 * <version 1>
 *
 * Spring Container에 보관된 객체중에서
 * HomeSerivce클래스를 이용하여 생성된 객체가 있으면 나에게 달라는 요청을함
 * SpringContainer는 자신이 보관하고 잇는 객체들 중에 
 * 같은 이름의 객체가 있으면 "주입"하여 사용할 수 있도록 만들어준다  (일종의 객체를 자동으로 생성해주는것과같다)
 * 
 * 	@Autowired
 *	HomeService homeService	
 *	접속자가 많이 발생할경우 메모리 누수(leak)가 발생하여 성능이 저하되는 현상이 발생할 수 있다.
 *
 * 새로운 스프링 New버젼 
 * <version 2>
 * 클래스를 객체로 선언할때 private, protected로 접근을 제한하고
 * final로 또한번 제한을 한다
 * 그리고 생성자에서 매개변수로 주입받아 선언된 객체를 사용할 수 있도록 한다
 * 메모리 관리 차원에서 권장하는 방식
 * 객체이름의 원칙 
 * 이방식으로 객체를 주입받으려면 
 * 클래스이름을 소문자로 첫글자에넣고 그대로 사용해야한다
 * protected final HomeSerice hSerivce;
 * 
 * public HomeController(HomeSerivce hService){
 * this.hService = hService;
 */

@Controller
public class HomeController {
	@Autowired
	HomeService homeService;
	protected final HomeService hService;
	public HomeController(HomeService hService) {
		this.hService= hService;
	}
	// "/" 요청을 하면 home이라는 메서드가 작동을 하겠다라고 선언한것 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("첫번째 : "+ homeService.add(200,500));
		System.out.println("두번째 : "+ hService.add(200,500));
		return "home";
	}
	
}
