package com.callor.hello.serivce;

import org.springframework.stereotype.Service;
/*
 * Spring Project에서 class를 선언하고
 * 각 class에 stereotype을 부착한다
 * <stereo type>
 * Component, Controller , Service, Repository..
 * 각 클래스의 stereo type을 부착하는 순간 Spring에게 이 class는 컨테이너에 보관해달라고 요청하는 것이다 
 * spring 을 스프링컨테이너라고도 부른다 이클래스들을 객체로 생성하여 보관하고 있어달라는 뜻이다
 * (Component를 남발하는 것은 낭비이기때문에 Controller를 예제로 사용한다)
 * 

 * 
 */
@Service
public class HomeService {

	
	public Integer add(int num1, int num2) {
		
		return num1 + num2;
	}
}
