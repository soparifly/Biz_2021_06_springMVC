package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	/*
	 * RequestMethod
	 * 
	 * GET : 조회(SLECT) - a tag의 link 클릭 POST: 요청(INSERT) -form 에 값을 입력하여 서버로 보낼때
	 * CRUD에서 활용하는 프로젝트를 할때 GET 방식으로 요청을함. (일반적인방법)
	 * 
	 * RESTfull HTTP Server 에서 추가하여 사용
	 * 
	 * PUT: 수정(UPDATE) DELETE : 삭제 (DELETE)
	 * 
	 * 를 배울예정 RequestMapping 이 같고 , RequestMethod가 같은 경우는 절대 허용하지 않는다
	 * 
	 * RequestMapping 이 같더라도 RequestMethod가 다르면 같이 사용할 수 있다
	 * 
	 * GET method방식으로 form에 담긴 데이터를 전송할때
	 * 
	 * - Http// ~ /hello/insert?name=홍길동&tel=전화번호 - 전송하는 데이터가 주소에 포함되어있어서 데이터가 쉽게
	 * 노출될수 있다. - 전체 URI (주소,데이터 등등)의 길이가 256 byte를 넘어가면 데이터가 잘리는 현상이발생한다
	 * 
	 * FOST method방식으로 form에 담긴 데이터를 전송할때
	 * 
	 * - 전송하는 데이터가 HTTP프로토콜의 BODY에 담겨서 전송되기때문에 일단 주소창등에 노출되지않는다 - Http// ~
	 * /hello/insert 만 - 이론상으로 전송하는 데이터크기에 제한이 없다, 다만 이미지와 같이 큰데이터를 전송하게되면 네트워크에 문제가
	 * 발생할 수 있어서 - 설정에서 일부 크기를 제한하기도한다 - 서버 입장에서 - Get:
	 * [http://localhost:8080/hello/insert?name=](http://localhost:8080/hello/insert
	 * ?name=) 홍길동으로 요청을 받았으면 - @RequestMapping(value = "/", method =
	 * RequestMethod.GET)를 처리하는 mehtod가 있어야한다 - Mapping=POST만 있을 경우 서버는 405HTTP
	 * 상태코드(@status Code)를 응답한다
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void my() {
	}
//
//	Spring에서는 Web으로부터 전달받은 데이터를 java mehtod의 매개변수를 설정하여 받을수있다
//
//	Spring framework 내부에서 reflection 이라는 코드가 작성되어서
//
//	전달받은 변수이름과 java method 의 매개변수와 이름 매칭 방법으로 변수를 받는다
//
//	이런 코드는 개발자가 신경쓰지 않아도 자동으로 작동 되는 코드이다getParameter()등의 코드를 이제 사용하지 않아도된다
//
//	그러나, JAVA method의 변수를 String 형이 아닌 것으로 숫자형, Boolean형 등 설정을 하면 Reflection이 실행되는 동안에 String형 데이터를 설정된 데이터 type으로 형변환 과정이 실행된다
//
//	- 이과정에서 형변환의 Exception이 발생하면 Reflection 코드가 중단되고 Spring 의 Dispatcher는 Web 400 상태코드로 응답한다
//	- 구체적인 어떤 문제가 발생했는지 알려주지않는다
	// Insert UrI mapping 으로 GET방식의 요청을 처리하겠다
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert(String dummy, int num) {
		
		Integer.valueOf(dummy);
		
//		String strNum = "300A";
		
//		Integer intNum = Integer.valueOf(strNum);
		
		
//		Numberformat exeption 이 발생할 예정이다 이상태로 서버를 시작하면 서버에서도 오류가 발생한다 

	}

	//// Insert UrI mapping 으로 POST방식의 요청을 처리하겠다
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert() {

		
		
	}
}
