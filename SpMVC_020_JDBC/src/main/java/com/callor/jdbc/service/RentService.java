package com.callor.jdbc.service;
/*
 * Servlet에서는 Controller에서 요청을 받아 DBMS를 핸들링 하는 코드를 Service가 담고있었다
 *
 *	Spring-MVC 프로젝트에서는 Dao 라는 새로운 개념이 시작된다
 *	Dao 는 보통 한 table 에 대한 CRUD를 구현하는 인터페이스 , 클래스 이다 
 *	프로젝트에서 다수의 (2개이상) table 이 존재하면 더불어 다수의 Dao 가 생성된다
 *	Code가 어떤 기능을 수행하기 위해서 한 테이블에 대해서 수행되는 경우도 있지만
 *	다수의 Table을 연계하여 기능이 수행되는 경우가 더 많아진다 
 *
 *	이때 Service 인터페이스와클래스는 다수의 table을 연계하여 수해되는 기능을 맡아 처리하는 역할을 한다
 *
 * 	Spring -MVC 프로젝트에서 Service 의 역할을 Business Logic이라고 한다.
 * 
 */
public interface RentService {

	public void viewBookAndCompany();
	
}
