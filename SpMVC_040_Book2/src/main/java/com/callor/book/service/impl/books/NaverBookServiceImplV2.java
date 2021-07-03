package com.callor.book.service.impl.books;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.controller.config.NaverQualifier;
import com.callor.book.model.BookDTO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;
/*
 * NaverBookServiceimplV1 에서는 AbstractService를 상속 받았고
 * NaverBookServiceimplV2 에서는 BookServicImplV1	을 상속받았
 *	
 * NaverAbstractService nService
 * 	= new NaverBookServiceImplV2() 처럼 선언 및 생성 가능
 * 
 * NaverAbstractService 추상 클래스에 정의된 jsonString() method를 
 * 물려받았고, NaverBookServiceImplV1 클래스에 정의된
 *  			queryURL(), getNaverList(), method를 물려받았다.
 *  
 *  따라서 NaverBookServiceImplV2 클래스에는 queryURL(), jsonString(), getNaverList()
 *  method 가 모두 있는 것과 같다.
 * 
 */
@Slf4j
@Service(NaverQualifier.NAVER_BOOK_SERVICE_V2)
public class NaverBookServiceImplV2 extends NaverBookServiceImplV1{
	
	
	@Override
	public List<BookDTO> getNaverList(String jsonString) throws ParseException {
	log.debug("나는 ServiceV2");
	JsonElement jSonElement = JsonParser.parseString(jsonString);
	JsonElement oItems = jSonElement.getAsJsonObject().get("items");
	
	Gson gson = new Gson();
	TypeToken<List<BookDTO>> typeToken = new TypeToken<List<BookDTO>>() {};
	List<BookDTO> bookList = gson.fromJson(oItems, typeToken.getType());
	
	return bookList;
	
	}
}
