package com.callor.book.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.book.service.impl.naverMainServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/naver")
@Controller
public class NaverController {

	@Qualifier("naverServiceImplV2")
	protected final naverMainServiceImpl nService;
	/*
	 * web client에서 서버로 Request를 할때 
	 * 어떤 데이터를 보내는 방법
	 * 1. ?=값 Get method방법 queryString 으로 데이터 보내기
	 * 	ex ) 주소창에 개인정보가 들어가는 경우는 해킹의 위험이 있따.
	 * 
	 * 2. requestBody에 담아 보내는 방법 
	 * <form>에 method=post로 지정하고 input을 사용하는 방법
	 * 
	 * 3. url Path (path variable 방식) 
	 * localhost:8080/book/naver/korea..
	 * localhost:8080/book/naver/korea/12345
	 * 주소창에 url 주소처럼 변수를 실어보내는방법
	 * 이렇게 보내면 컨트롤러에서는 
	 * mapping 을 (value="/naver/{user}/{password})
	 * 를 받을때위치에따른 {}내용을 변수에담아서 사용하는 방법
	 * 가장 최근의 방법이기도하다 . NODEJS 에서 처음 제공됨 
	 * 그래서 이방식을 spring 에ㅐ서 사용할때는 주소창에 중괄호 변수이름으로 (클라이언트에서 보내는 변수이름하고는 관련이없다 )
	 * 클라이언트에서 보내는 변수명과 controller에서 사용하는 변수는 관계가없다 
	 * 
	 * @PathVariable을 사용한다 
	 * 
	 * 
	 */
	@RequestMapping(value="/{CAT}",method=RequestMethod.GET)
	public String home(@PathVariable(name="CAT")String cat,
						@RequestParam(name = "search" ,defaultValue = "")String search
						, Model model) throws MalformedURLException, IOException, ParseException {
		log.debug("CAT {}",cat);
		
		model.addAttribute("CAT", cat);
		nService.naverGetData(cat, search, model);
		
		return "home";
	}
}
