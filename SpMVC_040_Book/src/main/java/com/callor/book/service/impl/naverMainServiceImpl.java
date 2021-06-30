package com.callor.book.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverBookService;
import com.callor.book.service.NaverMovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("naverMainServiceV1")
public class naverMainServiceImpl {

	@Qualifier("naverBookServiceV2")
	protected final NaverBookService nBookService;
	
	@Qualifier ("naverMovieSerivceV1")
	protected final NaverMovieService nMovieService;
	
	public void naverGetData(String cat, String search, Model model)
			throws MalformedURLException, IOException, ParseException {
		if (search != null && !search.equals("")) {
			if (cat.equalsIgnoreCase("BOOK")) {
//				 	도서검색서비스
				String queryURL = nBookService.queryURL(search);
				String jSonString = nBookService.getJsonString(queryURL);
				List<BookDTO> books = nBookService.getNaverList(jSonString);
				model.addAttribute("BOOKS", books);

			} else if (cat.equalsIgnoreCase("NEWS")) {
//					뉴스검색서비스
			} else if (cat.equalsIgnoreCase("MOVE")) {
//					영화검색서비스
				String queryURL = nMovieService.queryURL(search);
				String jSonString = nMovieService.getJsonString(queryURL);
				List<MovieDTO> movie = nMovieService.getNaverList(jSonString);
			}
		}
	}
}
