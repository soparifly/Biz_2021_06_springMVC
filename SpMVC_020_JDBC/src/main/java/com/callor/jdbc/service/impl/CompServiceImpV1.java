package com.callor.jdbc.service.impl;

import java.util.List;

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
		
		
		return compDao.insert(vo);
	}
	@Override
	public List<CompVO> findByCName(String cp_name) {
		// TODO Auto-generated method stub
//		전달받은 출판사 이름에서앞뒤의 빈칸을 제외하고 Dao에게 Toss하기
		
		return compDao.findByCName(cp_name.trim());
		
		
	}
	@Override
	public List<CompVO> selectAll() {
		// TODO Auto-generated method stub
		
		
		return compDao.selectAll();
	}
	@Override
	public CompVO findByCCode(String sp_code) {
		// TODO Auto-generated method stub
		return compDao.findById(sp_code.trim());
	}
	@Override
	public List<CompVO> findByTitleAndCeoAndTel(String Text) {

			List<CompVO> mainList = compDao.findByCName(Text);
			List<CompVO> ceoList = compDao.findByCeo(Text);
			List<CompVO> telList = compDao.findByTel(Text);
			
			mainList.addAll(ceoList);
			mainList.addAll(telList);
		return mainList;
	}
	
}
