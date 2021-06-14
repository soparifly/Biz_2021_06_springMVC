package com.callor.jdbc.service.impl;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.service.CompService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("compSerivceV1")
public class CompServiceImpV1 implements CompService {

	protected final CompDao compDao;
//	protected final CompService compService;
	public CompServiceImpV1(CompDao compDao) {
//		this.compService =  compService;
		this.compDao = compDao;
	}
	@Override
	public int insert(CompVO vo) {
		// TODO Auto-generated method stub
		String cpCode = compDao.findByMaxCode();
		log.debug("Cpcode {} " + cpCode);
		
		if(cpCode == null||cpCode.equals("")) {
			//C00001
			cpCode = String.format("C%04d", 1);
		} else {
			
			String _code = cpCode.substring(1);
			Integer intCode = Integer.valueOf(_code)+1;
			cpCode= String.format("C%04d",intCode);
			
		}
		vo.setCp_code(cpCode);
		compDao.insert(vo);
		
		return 0;
	}

}
