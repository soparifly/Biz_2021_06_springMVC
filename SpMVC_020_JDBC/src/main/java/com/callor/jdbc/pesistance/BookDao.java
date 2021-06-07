package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.BookVO;

/*
 * Dao(Data Access Object)
 * Service -> Dao -> DBMS 과정에서
 * 실질적인 1개 table 에 대한 CRUD를 담당할 interface, class
 *
 * Servlet project 에서 Service가 실행했던 역할을 Dao가 실행하게 된
 */

public interface BookDao extends GenericDao<BookVO, String>{
	//Generic에 선언된 메서드에 추가하여 도서정보 
	//도서명 검색하기
	public List<BookVO> findByName(String name);
	//출판일로검색하
	public List<BookVO> findByDate(String date);
	
	public List<BookVO> findByComp(String comp);
	
	public List<BookVO> findByAuthor(String author);


}
