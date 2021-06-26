package com.callor.score.dao.ext;

import com.callor.score.dao.GenericDao;
import com.callor.score.model.SubjectVO;

public interface SubjectDao extends GenericDao<SubjectVO, String>{

//	학생 테이블에저장된 테이블에서
//	가장 마지막의 학번 (가장 큰 번호)를 추출하기 
	public String getMaxStNum();
	
}
