package com.callor.book.service.impl.books;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.controller.config.NaverQualifier;
import com.callor.book.controller.config.NaverSecret;
import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverAbstractService;

import lombok.extern.slf4j.Slf4j;
/*
 * NaverAbstractService 추상클래스를 상속받아 구현(된) 클래스
 * 추상클래스에 사전 정의 된 jsonString() method 코드는
 * 직접 작성하지 않고, 
 * 사용할 수 있다.
 * 
 * 	jsonString()
 * 
 *  추상메서드는 반드시 구현해야한다
 *  	queryURL, getNaverList()
 *  
 *	NaverAbstractService nService
 *	=	new NaverServiceImplV1()
 *
 *  nService.queryURL()
 *  nService.jsonString()
 *  nService.getNaverList()
 *  
 */
@Slf4j
@Service(NaverQualifier.NAVER_BOOK_SERVICE_V1)
public class NaverBookServiceImplV1 extends NaverAbstractService<BookDTO> {
	public String queryURL(String search) {
		String searchUTF8 = null;

		try {
			searchUTF8 = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		StringBuilder queryURL = new StringBuilder();

		queryURL.append(NaverSecret.NURL.BOOK); // queryString += BookURL

		String queryString = String.format("?query=%s", searchUTF8);
		queryURL.append(queryString);

		queryString = String.format("&display=%d", 20);
		queryURL.append(queryString);

		log.debug(queryURL.toString());

		return queryURL.toString();
	}
	@Override
	public List<BookDTO> getNaverList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub
		log.debug("나는 ServiceV1");
		//		1. json Parsing 도구 선언
		JSONParser jParser = new JSONParser();
		JSONObject jObject = (JSONObject) jParser.parse(jsonString);

		JSONArray items = (JSONArray) jObject.get("items");

		List<BookDTO> bookList = new ArrayList<BookDTO>();

		int nSize = items.size();
		for (int i = 0; i < nSize; i++) {

			JSONObject item = (JSONObject) items.get(i);

			//			한권의 도서정보가 담긴 객체 추출
			String title = (String) item.get("title");				 //	string	검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
			String link = (String) item.get("link");				 //	string	검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
			String author = (String) item.get("author");			 //	string	저자 정보이다.
			String image = (String) item.get("image");				 //	string	썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타납난다.
			String price = (String) item.get("price");				 //	integer	정가 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
			String discount = (String) item.get("discount"); 		 //	integer	할인 가격 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
			String publisher = (String) item.get("publisher"); 		 //	string	출판사 정보이다.
			String isbn = (String) item.get("isbn"); 				 //	integer	ISBN 넘버이다.
			String description = (String) item.get("description"); 	 //	string	검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
			String pubdate = (String) item.get("pubdate");

			BookDTO bookDTO = BookDTO.builder().title(title).link(link).author(author).price(price).image(image)
					.publisher(publisher).discount(discount).isbn(isbn).description(description).pubdate(pubdate)
					.build();
			//				List에 add하기
			bookList.add(bookDTO);
		}
		log.debug(bookList.toString());
		return bookList;

	}

}
