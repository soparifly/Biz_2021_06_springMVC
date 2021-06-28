package com.startea.team.dao.ext;

import java.util.List;

import com.startea.team.dao.GenericDao;
import com.startea.team.model.CustomVO;

public interface CustomDao extends GenericDao<CustomVO, String> {

	public List<CustomVO> category1();
}
