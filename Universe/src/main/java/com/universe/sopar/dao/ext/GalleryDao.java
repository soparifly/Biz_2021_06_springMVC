package com.universe.sopar.dao.ext;

import java.util.List;

import com.universe.sopar.dao.GenericDao;
import com.universe.sopar.model.GalleryDTO;
import com.universe.sopar.model.GalleryFilesDTO;

public interface GalleryDao extends GenericDao<GalleryDTO, Long>{
	
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq);
	public GalleryDTO findByIdGalleryFilesResultMap(Long g_seq);
	public Integer countAll();
	
}
