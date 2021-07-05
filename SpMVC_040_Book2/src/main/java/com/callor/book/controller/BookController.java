package com.callor.book.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.callor.book.model.BookDTO;
import com.callor.book.service.BookService;
import com.callor.book.service.impl.BookServiceImplV1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/book")
@Controller
public class BookController {

	protected final BookService bookService; 
	
	@RequestMapping(value = "/insert/{isbn}", method = RequestMethod.GET)
	public String insert(@PathVariable("isbn") String isbn, Model model) throws Exception {

		log.debug("isbn: {}",isbn);
		int ret = bookService.insert(isbn);
		return "redirect:/book/list";
	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView selectAll(Model model){
		
		List<BookDTO> bkList = bookService.selectAll();
		log.debug("bkList: {} ", bkList.toString());
/*
 * 통상적인 Spring Framework의 method에서는
 * view파일의 이름을 String 형으로 return 하고
 * view에서 랜더링할 데이터는 Model 객체에 Attribute로 담아서
 * 보내는 방식이다
 * 
 * ModelAndView객체를 별도로 생성하여
 * view는 setViewName() method 이용하여 추가하고
 * ModelAndView객체를 return 하는 방식도 사용한다
 */
//		model.addAttribute("BKLIST", bkList);
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("MY_BOOKS", bkList);
		
//		return "book/list_view";
		return mv;
	}
}
