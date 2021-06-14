package com.callor.jdbc.pesistance;

import com.callor.jdbc.model.CompVO;

public interface CompDao extends GenericDao<CompVO, String>{
	
	public String findByMaxCode();

	
}
