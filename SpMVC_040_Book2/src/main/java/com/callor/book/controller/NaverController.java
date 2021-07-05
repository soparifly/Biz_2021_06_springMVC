package com.callor.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.book.controller.config.NaverQualifier;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.impl.naverMainService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/naver")
@Controller
public class NaverController {

	@Qualifier(NaverQualifier.NAVER_MAIN_SERVICE_V1)
	protected final naverMainService nService;

	//	protected final BookService myBookService;

	@RequestMapping(value = "/{CAT}", method = RequestMethod.GET)
	public String home(@PathVariable(name = "CAT") String cat,
			@RequestParam(name = "search", required = false, defaultValue = "") String search, Model model)
			throws Exception {
		log.debug("CAT {}", cat);
		//		List<BookDTO> myBookList = myBookService.selectAll();
		//		model.addAttribute("MY_BOOKS", myBookList);
		//		
		model.addAttribute("CAT", cat);
		nService.naverGetData(cat, search, model);
		return "home";
	}

	/*
	 * produces
	 * 일반적인 문자열이 아닌 JSON 형태의 String 을 보내니 표시할때 JSON 타입을 인식하여 보여라 라른 ㄴ지시어 이지시어를 추가하지않으면 return ytpe 이 String 이기때문에 단순 문자열로 처리해버린
	 */
	@ResponseBody
	@RequestMapping(value = "/get/json", method = RequestMethod.GET, produces = "application/json;char=UTF8")
	public String getJson() throws Exception {

		String cat = "NEWS";
		String search = "COVID";
		String jsonString = nService.naverGetJsonString(cat, search);
		return jsonString;
	}

	@ResponseBody
	@RequestMapping(value = "/get/list")
	public List<NewsDTO> getNews(String search) throws Exception {

		return nService.naverGetList(search);

	}

}
