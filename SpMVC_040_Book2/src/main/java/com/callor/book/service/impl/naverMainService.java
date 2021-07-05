package com.callor.book.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.controller.config.NaverQualifier;
import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.NaverAbstractService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Service(NaverQualifier.NAVER_MAIN_SERVICE_V1)
public class naverMainService {

	@Qualifier(NaverQualifier.NAVER_BOOK_SERVICE_V2)
	protected final NaverAbstractService<BookDTO> nBookService;
	
	@Qualifier(NaverQualifier.NAVER_MOVIE_SERVICE_V1)
	protected final NaverAbstractService<MovieDTO> nMovieService;
	
	@Qualifier(NaverQualifier.NAVER_NEWS_SERVICE_V1)
	protected final NaverAbstractService<NewsDTO> nNewsService;
	
	@Qualifier(NaverQualifier.NAVER_NEWS_SERVICE_V2)
	protected final NaverAbstractService<NewsDTO> nNewsServiceV2;
	
	
	public void naverGetData(String cat, String search, Model model)
			throws Exception {
		if (search != null && !search.equals("")) {
			if (cat.equalsIgnoreCase("BOOK")) {
//				 	도서검색서비스
				String queryURL = nBookService.queryURL(search);
				String jSonString = nBookService.getjsonString(queryURL);
				List<BookDTO> books = nBookService.getNaverList(jSonString);
				model.addAttribute("BOOKS", books);

			} else if (cat.equalsIgnoreCase("NEWS")) {
//					뉴스검색서비스

				String queryURL = nNewsService.queryURL(search);
				
				/*
				 * <V1>
				 * queryURL 을 생성하고 
				 * nave에 JSONstirng 을 요청하고 
				 * Gson 을 사용하여 parsing 하여 List<NewsDTO>를 얻었다,.]
				 * 
				 * <V2>
				 * queryURL 을 생성하고
				 * naver에 JSON strign	을 요청하는대신 
				 * (getJsonString() method를 사용하지 않겠다)
				 * 
				 * 대신에 , getNaverList() method 에 quryURL을 직접 주입하여 데이터를 가져오기
				 * 
				 * 
				 */
//				parsing 작
//				String jSonString = nNewsService.getjsonString(queryURL);
//				log.debug(" jSonString :{}",jSonString);
//				List<NewsDTO> newsList  = nNewsService.getNaverList(jSonString);
				List<NewsDTO> newsList  = nNewsService.getNaverList(queryURL);
				model.addAttribute("NEWS_LIST", newsList);
				
			} else if (cat.equalsIgnoreCase("MOVIE")) {
//					영화검색서비스
				String queryURL = nMovieService.queryURL(search);
				String jSonString = nMovieService.getjsonString(queryURL);
				log.debug(" jSonString :{}",jSonString);
				List<MovieDTO> movieList = nMovieService.getNaverList(jSonString);
				model.addAttribute("MOVIE_LIST", movieList);
			}
		}
	}

	
	public String naverGetJsonString(String cat, String search) throws IOException {
		// TODO Auto-generated method stub
		String queryURL = nNewsService.queryURL(search);
		String jsonString = nNewsService.getjsonString(queryURL);
		
		return jsonString;
	}
	
	public List<NewsDTO> naverGetList(String search) throws Exception{
		
		String queryURL = nNewsServiceV2.queryURL(search);
		
		return nNewsServiceV2.getNaverList(queryURL);
	}
}
