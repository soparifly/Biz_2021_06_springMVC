package com.startea.team.service;

import java.util.List;

import com.startea.team.model.EventVO;

public interface EventService {
//	이벤트 서비스, 스타벅스 내부에 공개되어있는 이벤트기간과 , 이벤트 내용등을 게시하려고한다
// 달력형식을 이용한 리스트형 게시판	
	
	public List<EventVO> event();

}
