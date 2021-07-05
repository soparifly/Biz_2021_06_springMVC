package com.team.starbucks.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.starbucks.dao.ext.BoardDao;
import com.team.starbucks.model.BoardDTO;
import com.team.starbucks.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Service("boardServiceV1")
public class BoardServiceImplV1 implements BoardService {

	protected final BoardDao bdDao;

	@Override
	public List<BoardDTO> selectAll() {
		
		log.debug("리스트목록 {} ", bdDao.toString());
		List<BoardDTO> bdList = bdDao.selectAll();
		
		return bdList;
	}

}
