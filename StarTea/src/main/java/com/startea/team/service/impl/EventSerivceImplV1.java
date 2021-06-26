package com.startea.team.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.startea.team.dao.ext.EventDao;
import com.startea.team.model.EventVO;
import com.startea.team.service.EventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 여기에 들어가야할 기능
 */

@Slf4j
@RequiredArgsConstructor
@Service("eventService")
public class EventSerivceImplV1 implements EventService {

	protected final EventDao evDao;

	@Override
	public List<EventVO> event() {
		// TODO Auto-generated method stub
		return evDao.selectAll();
	}

}
