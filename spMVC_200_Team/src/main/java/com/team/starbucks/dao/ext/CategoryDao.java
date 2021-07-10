package com.team.starbucks.dao.ext;

import java.util.List;

import com.team.starbucks.dao.GenericDao;
import com.team.starbucks.model.CategoryDTO;

public interface CategoryDao extends GenericDao<CategoryDTO,String>{

	public List<CategoryDTO> findByMenukinds(int menukinds);
}
