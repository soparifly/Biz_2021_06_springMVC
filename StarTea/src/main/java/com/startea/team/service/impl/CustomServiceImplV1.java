package com.startea.team.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysql.cj.log.Log;
import com.startea.team.dao.ext.CustomDao;
import com.startea.team.model.CustomVO;
import com.startea.team.service.CustomService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 여기에 들어가야할 기능
 */
@Slf4j
@RequiredArgsConstructor
@Service("customService")
public class CustomServiceImplV1 implements CustomService {

	protected CustomDao ctDao;

	@Override
	public List<CustomVO> selectAll() {
		// TODO Auto-generated method stub
		List<CustomVO> ctList = ctDao.selectAll();
		log.debug("select All : ",ctList.toString());
		return ctList;
	}
	public List<CustomVO> selectCategory(String prefix){
//	앞자리를 입력받아서 목록내부에서 검색해서 출력함 
		return ctDao.category1();
	}


}
