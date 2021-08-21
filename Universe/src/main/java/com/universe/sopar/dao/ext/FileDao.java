package com.universe.sopar.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.universe.sopar.dao.GenericDao;
import com.universe.sopar.model.FileDTO;

public interface FileDao extends GenericDao<FileDTO, Long>{

	
	
	public int insertOrUpdate(FileDTO fileDTO);
	public int insertWidthList(@Param("fileList") List<FileDTO> fileList);
	public int insertOrUpdateWithList(@Param("fileList") List<FileDTO> fileList);
	
}
