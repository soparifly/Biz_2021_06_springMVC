package com.callor.book.notuse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverBookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Controller
//@RequestMapping(value = "/naver")
public class NaverExitContorller {
	@Qualifier("naverServiceImplV1")
	protected final NaverBookService nBookService;

//	코드를 바꾸지않고 버젼만 바꿔서 사용할수 있다.

	@ResponseBody
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public List<BookDTO> book(String search) throws MalformedURLException, IOException, ParseException {
		String queryURL = nBookService.queryURL(search);
		String jsonString = nBookService.getJsonString(queryURL);

		List<BookDTO> bookList = nBookService.getNaverList(jsonString);

		return bookList;
	}

}
