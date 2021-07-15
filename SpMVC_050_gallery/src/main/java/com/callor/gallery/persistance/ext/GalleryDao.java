package com.callor.gallery.persistance.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.persistance.GenericDao;

public interface GalleryDao extends GenericDao<GalleryDTO,Long>{

	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq);
	public GalleryDTO findByIdGalleryFilesResultMap(Long g_seq);
	
	public Integer countAll();
	/*
	 * mapper에서 전달받은 변수가 2개이상일 경우에는 
	 * 반드시 @Param()을 사용하여 변수명을 명시해주어야한다
	 * mapper에서는 @Param()으로 지정된 변수명을 사용하여 처리하여아한다,
	 * 
	 */
	// 다오에서 2개이상의 변수를 받을때는 반드시 param으로 들어갈 변수이름을 지정해줘야한다
	public List<GalleryDTO> findBySearch(@Param("column")String search_column, @Param("text")String search_text);
}
