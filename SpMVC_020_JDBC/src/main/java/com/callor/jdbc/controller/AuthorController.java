package com.callor.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/author")
public class AuthorController {
	
	protected final AuthorService auService;
	public AuthorController( AuthorService auService) {
	this.auService= auService;
	}
	
	
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String list(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO)hSession.getAttribute("USERVO");
		if(userVO== null) {

			model.addAttribute("MSG", "LOGIN");
			return "redirect:/member/login";
			
		}
		log.debug("Author Root");
		
		List<AuthorVO> auList= auService.selectAll();
		log.debug("저자정보 : {} " , auList.toString());
		/*
		 * atturibute를 지정할때 흔히 저지르는 실수 att의 이름은 문자열 형태이기때문에 어떠한 기호를 사용해도 무장하다
		하지만 jsp 에서 랜더링 할때는 ( - ) 문자열이 변수로 취급이 된다 변수로 취급 된다는 것은 java의 일반적인코딩 규칙이 적용된다는 것이다
		작성할때는 비록 문자열이지만, 변수명명 규칙에맞도록 이름을 작성 해야 한다 그렇지 않으면 jsp 에서 오류를 발생시킨다
		 */
		model.addAttribute("AUTHORS",auList);
		return "author/list";
	}
	/*
	 * cp_title을 Req로 부터 받아 변수에 세팅하는데 REq를 할때 cp_title 변수를 보내지 않으면
	 * 400 httpStatus 오류가 발생한다
	 * 400 오류는 서버 app 디버깅 과정에서 상당히 관리하기 어려운 변수가 된다 
	 * 
	 * 단순한변수(VO, DTO, MAP 형식이 아닌 단일변수)의 경우는 
	 * ㄱ@requsestparam의 required 옵션을 flase 로 선언하고 
	 * default값을 임의로 설정해두면 코드 내에서 핸들을 할 수 있다.
	 * 
	 */
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String search(@RequestParam(name="au_name", required =false, defaultValue = "")String au_name,Model model) {
		if(au_name == null || au_name.equals("")) {
			List<AuthorVO> authorList = auService.selectAll();
			model.addAttribute("AUTHORS",authorList);
		} else {
			List<AuthorVO> authorList =  auService.findByANameANDTel(au_name);
			model.addAttribute("AUTHORS",authorList);
		}
		return "author/search";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "author/input";
	}

}
