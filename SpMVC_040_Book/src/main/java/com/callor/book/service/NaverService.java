package com.callor.book.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverService {
/*
 * naver에 요청하기
 * bookURL + "?query=" + 검색 문자열 
 * 
 * 
 * 
 * */
	protected final String bookURL = "https://openapi.naver.com/v1/search/book.json";
	
	protected final String newsURL = "https://openapi.naver.com/v1/search/news.json";
	
	protected final String movieURL = "https://openapi.naver.com/v1/search/movie.json";
	

	public String queryURL(String search) {
		
//		검색하고자 하는 문자열을 UTF-8로 인코딩
		String searchUTF8 =null;
		try {
			searchUTF8 =  URLEncoder.encode(search,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuilder queryURL = new StringBuilder();
		queryURL.append(bookURL);  // queryString += BookURL
		
		String queryString = String.format("?query=%s", search);
		queryURL.append(queryString);
		
		queryString = String.format("&display=%d", 20);
		
		return null;
		
	}
	
	
}
