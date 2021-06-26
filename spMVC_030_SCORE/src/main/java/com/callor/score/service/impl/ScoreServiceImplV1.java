package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("ScoreSerivceV1")
public class ScoreServiceImplV1 implements ScoreService {
	
	protected final ScoreDao scDao;

	@Override
	public List<ScoreDTO> scoreAllList() {
		// TODO Auto-generated method stub
		List<ScoreDTO> scoreList = scDao.selectViewAll();
		log.debug("Score{} ",scoreList.toString());
		
		return scoreList;
	}

	@Override
	public List<SubjectAndScoreDTO> selectScore(String st_num) {
		// TODO Auto-generated method stub
		
		List<SubjectAndScoreDTO> ssList = scDao.selectSubjcetAndScore(st_num);
		
		return ssList;
	}

}
