package com.callor.book.controller;

import java.util.List;

import com.callor.book.model.NewsDTO;
/*
 * Naver News 정보를 담는 NewsDTO 클래스를 List로 선언한 부모 DTO 선
 */

public class NaverParentDTO {
//	참고용으로 포함한 데이터
	public String lastBuildDate;	//": "Mon, 05 Jul 2021 09:30:30 +0900",
	public String total;			//": 440110,
	public String start;			//": 1,
	public String display;			//": 10,
	
//	items는 가장중요한 변수이다.
//	naver에서 데이터가 전송되어 올때
//	필요한 데이터는 items항목에 배열로 담겨온다
//	부모DTO에서 List타입으로 items변수를 선언한다
	public List<NewsDTO> items;		//": [
	
}
