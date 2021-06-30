package com.callor.book.notuse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverBookService;
import com.google.protobuf.TextFormat.ParseException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@RequestMapping(value = "/book")
//@Controller
public class NaverBookController {
	
	@Qualifier("naverServiceImplV1")
	protected final NaverBookService nBookService;
	
	
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home1(@RequestParam(name="search",required = false, defaultValue = "")String search, Model model) throws MalformedURLException, IOException, ParseException, org.json.simple.parser.ParseException {
		
//		model.addAttribute("pHolder","책 검색어");
		model.addAttribute("CAT", "BOOK");
		
		if(search != null && !search.equals("")) {
			
			String queryURL = nBookService.queryURL(search.trim());
			String jsonString = nBookService.getJsonString(queryURL);
			
			
			List<BookDTO> bookList = nBookService.getNaverList(jsonString);
			
			model.addAttribute("BOOKS",bookList);
			
		}
		
		return "home";

	}
}
