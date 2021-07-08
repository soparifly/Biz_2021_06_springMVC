package com.callor.gallery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.gallery.model.MemberVO;
import com.callor.gallery.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/member")
@Controller
public class MemberController {

	protected final MemberService memService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("BODY", "JOIN");
		return "home";
	}

	/*
	 * 폼에서 받아지는변수가 많아질때는 (2개이상)
	 * VO를 만드는것이 좋다 .
	 * 
	 */
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, MemberVO memberVO) {

		log.debug("회원가입정보 {} ", memberVO.toString());
		memberVO = memService.join(memberVO);
		model.addAttribute("BODY", "JOIN");
		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/id_check", method = RequestMethod.GET)
	public String id_check(String m_userid) {
		//		fetch를 이용하여 ajax데이터 날린거 받은걸 사용하는것
		log.debug("중복검사를 수행할 ID : {} ", m_userid);
		MemberVO memberVO = memService.findById(m_userid);

		if (memberVO == null) {
			return "NOT_USE_ID";
		} else {
			return "USE_ID";
		}
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BODY", "LOGIN");
		return "home";
	
	}
//	model에 담겨있는 데이터는 일회성으로 처리되는데
//	 HttpSession의 경우는 어느정도까지 데이터를 유지하고있다
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(Model model,MemberVO memberVO,HttpSession session) {
		memberVO = memService.login(memberVO,model);
		if(memberVO == null) {
//			에드인이유는 return 문이 실행되면 소멸된다
			model.addAttribute("BODY", "LOGIN");
			return "home";
		} else {
//			사용자 ID도 정상, 비밀번호 확인 정상
//			HttpSession에 사용자 정보가 담긴 memberVO를 
//			속성으로 세팅한다
//			set은 add 와는 별개로 처리되기때문에 사용자의유의가 필요하다
//			서버과부하를 초래할수 있다.
			/*
			 * HttpSession 에 속성으로 setting 된 값은 
			 * 어떠한 type이라도 상관없다
			 * 하지만 HttpSession에 담긴 속성은
			 * 임의로 삭제하거나, 초기화하거나 서버가 멈추거나, 일정
			 * 조건이 성립되지않으면,서버메모리에 
			 * 1. 가급적 작은 크기의 데이터만 담아야한다
			 * 영구히 남아있다
			 * 2. 필요없으면 반드시 소멸시켜야한다
			 * 3. 자동 소멸되는 조건을 잘 지정해야한다
			 * 
			 */
			session.setAttribute("MEMBER", memberVO);
			
			return "redirect:/";
		}
	}
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
//		세션에 다른 세션의 항목이 들어있을 수 있기때문에 MEMEBER항목만 삭제하라는명령어
		session.removeAttribute("MEMBER");
		return "redirect:/";
	}
	
}
