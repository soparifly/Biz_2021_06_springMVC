package com.callor.jdbc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.service.AuthorService;
import com.callor.jdbc.service.BookService;
import com.callor.jdbc.service.CompService;
import com.callor.jdbc.service.HomeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("homeServiceV1")
public class HomeServiceImplV1 implements HomeService{

	
	protected final BookService bookService;
	protected final AuthorService auService;
	protected final CompService cpService;
	/*
	 *	 Main page에서 보여주는 도서정보, 출판사 정보, 저자정보 데이터를 각각의 서비스 로부터 수집하기
	 *	
	 */
	@Override
	public void dashBoard(Model model) {
		// TODO Auto-generated method stub
	
		List<BookVO> bookList = bookService.selectAll();
		List<AuthorVO> auList = auService.selectAll();
		List<CompVO> compList = cpService.selectAll();
		
		/*
		 * model 객체는 Controller에서사용하는 view 를 렌더링 하는 데이터를 담는 도구이다
		 * 3개의 dao로 부터 데이터를 받아서 controller 로 return 하려면 
		 * 상당히 불편한 상황이 연출 될 수 있다
		 * 이때, 
		 * 
		 *  Controller 로 부터 model 객체를매개변수로 받아서 model 객체에 Atturibute를 추가하면
		 *  Controller 의 원레 model 에도 Attribute가 추가되는 효과를 낼수 있다
		 *  
		 *  Call by Reference처럼 작동하는 Java의 객체 성질을 활용하기
		 */
		model.addAttribute("BOOKS",bookList);
		model.addAttribute("AUTHORS",auList);
		model.addAttribute("COMPS",compList);
		
		
	}

}
