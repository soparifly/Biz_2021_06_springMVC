package com.team.starbucks.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team.starbucks.dao.ext.CategoryDao;
import com.team.starbucks.dao.ext.CustomDao;
import com.team.starbucks.dao.ext.FileDao;
import com.team.starbucks.model.CustomDTO;
import com.team.starbucks.model.CustomVO;
import com.team.starbucks.model.FileDTO;
import com.team.starbucks.service.CustomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("customServiceV1")
public class CustomServiceImplV1 implements CustomService{

	protected final CategoryDao cateDao;
	protected final CustomDao cusDao;
	protected final FileDao fDao;
	@Override
	public List<CustomDTO> selectAll() {
		return cusDao.selectAll();
	}
	public String detail(Model model, Long menu_seq, Long file_seq) {
		
		CustomDTO customDTO = cusDao.findById(menu_seq);
		FileDTO fileDTO = fDao.findById(file_seq);
		
		return null;
	}
	public int insert(CustomVO customVO) {
		return cusDao.insert(customVO);
	}
	public int update(CustomVO customVO) {
		return cusDao.update(customVO);
	}
	public int delete(CustomVO customVO) {
		return cusDao.delete(customVO);
		
	}
	
	
}
