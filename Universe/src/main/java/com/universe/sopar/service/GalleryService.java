package com.universe.sopar.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.universe.sopar.model.GalleryDTO;
import com.universe.sopar.model.GalleryFilesDTO;

public interface GalleryService {

	
	public List<GalleryDTO> selectAll() throws Exception;
	
	public void input(GalleryDTO galleyDTO, MultipartFile one_file, MultipartHttpServletRequest multi_file) throws Exception;
	
	public List<GalleryFilesDTO> fileByIdGalleryFiles(Long g_seq) throws Exception;
	
	public int delete(Long g_seq);
	public int file_delete(Long g_seq);
	
}
