package com.universe.sopar.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.universe.sopar.dao.ext.FileDao;
import com.universe.sopar.dao.ext.GalleryDao;
import com.universe.sopar.model.FileDTO;
import com.universe.sopar.model.GalleryDTO;
import com.universe.sopar.model.GalleryFilesDTO;
import com.universe.sopar.service.FileService;
import com.universe.sopar.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("galleryServiceImplV1")
public class GalleryServiceImplV1 implements GalleryService{
	
	@Qualifier("fileServiceV1")
	protected final FileService fileService;
	
	protected final GalleryDao galleryDao;
	protected final FileDao fileDao;
	
	@Autowired
	public void create_table() {
		Map<String,String> maps = new HashMap<String, String>();
		galleryDao.create_table(maps);
		fileDao.create_table(maps);
		
	}
	
	
	@Override
	public List<GalleryDTO> selectAll() throws Exception {
		// TODO Auto-generated method stub
		
		List<GalleryDTO> galleryList = galleryDao.selectAll();
		
		return galleryList;
	}
	
	

	@Override
	public void input(GalleryDTO galleyDTO, MultipartFile one_file, MultipartHttpServletRequest multi_file)
			throws Exception {
		// TODO 파일 갤러리데이터 입력
		 String strUUID = fileService.fileUp(one_file);
		 galleyDTO.setG_image(strUUID);
		 
		 galleryDao.insert(galleyDTO);
		 
		 Long g_seq = galleyDTO.getG_seq();
		 
		 List<FileDTO> files = new ArrayList<FileDTO>();
		 
		 List<MultipartFile> mfiles = multi_file.getFiles("multi_file");
		 for(MultipartFile file : mfiles) {
			 
			 String fileOriginalName = file.getOriginalFilename();
			 String fileUUName = fileService.fileUp(file);
			 
			 FileDTO fileDTO = FileDTO.builder().file_gseq(g_seq).file_originalName(fileOriginalName).file_upName(fileUUName)
					 			.build();
			 files.add(fileDTO);
			 }
		fileDao.insertOrUpdateWithList(files);
		
	}

	@Override
	public List<GalleryFilesDTO> fileByIdGalleryFiles(Long g_Seq) throws Exception {
		// TODO Auto-generated method stub
		List<GalleryFilesDTO> galleryFileList = galleryDao.findByIdGalleryFiles(g_Seq);
		if(galleryFileList != null && galleryFileList.size() > 0) {
			log.debug(galleryFileList.toString());
		} else {
			log.debug("조회된 데이터 없음");
		}
		return galleryFileList;
	}

	@Override
	public int delete(Long g_seq) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int file_delete(Long g_seq) {
		// TODO Auto-generated method stub
		FileDTO fileDTO = fileDao.findById(g_seq);
		
		int ret = fileService.delete(fileDTO.getFile_upName());
		if(ret > 0) {
			fileDao.delete(g_seq);
		}
		return 0;
	}
	

	
}
