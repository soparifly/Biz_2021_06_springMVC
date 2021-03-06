package com.callor.gallery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.callor.gallery.model.FileDTO;
import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.persistance.ext.FileDao;
import com.callor.gallery.persistance.ext.GalleryDao;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.PageService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("galleryServiceV2")
public class GalleryServiceImplV2 extends GalleryServiceImplV1{

public GalleryServiceImplV2(GalleryDao gaDao, FileDao fDao, @Qualifier("fileServiceV2")FileService fService, @Qualifier("pageServiceV1")PageService pageService) {
		super(gaDao, fDao, fService, pageService);
	}
/*
 * @RequireArgConstructor를 사용한 클래스를 상속받을때는
 * 상속받은 클래스에서  문제로 상속받은 
 * 클래스에서 강제로 생성자를 만들어야 한다
 * 
 * eclipse	의 자동완성 기능을 사용하여 생성자를 만든다
 * 만약 매개변수로설정된 요소중에 interface를 상속받은 클래스가 
 * 2개 이상일 경우 @Quarlifier를 설정해야하는데
 * 이때 각 매개변수의 요소 type앞에 작성해주면된다 
 */  

	public GalleryDTO findByIdGallery(Long g_seq) {
		
		
		GalleryDTO gallery = gaDao.findByIdGalleryFilesResultMap(g_seq);
		
		if(gallery != null) {
			
			log.debug("갤러리 데이터 {}", gallery);
		}
		return gallery;
	}
	/*
	 * 첨부 파일이 있는 게시물 삭제하기
	 * 
	 * 
	 * 
	 * 
	 * 1. 첨부파일을 제거한 후 
	 * 	가. 첨부파일을 삭제하기 위하여 데이터를 다시 select하여
	 * 		첨부 파일 이름을 가져와야한다 
	 * 	나. 가져온 이름으로 데이터를 삭제하고 
	 * 2. 게시물 데이터를 삭제해야한다
	 * 3. 첨부파일뿐만 아니라 JOIN된 데이터가 또 있다
	 * 	JOIN된 데이터에 첨부파일 정보가 또있다.
	 * 
	 * 1. JOIN된 데이터의 첨부파일을 삭제한 후
	 * 2. JOIN된 데이터를 삭제하고 
	 * 3. 본문(Galley)의 첨부 파일을 삭제하고
	 * 4. 본문을 삭제
	 * 
	 */
	@Override
	public int delete(Long g_seq) {
		GalleryDTO gaDTO = gaDao.findByIdGalleryFilesResultMap(g_seq);
		
		if(gaDTO == null) {
			return 0;
		}
		
		List<FileDTO> fileList = gaDTO.getFileList();
		for(FileDTO file : fileList) {
			//첨부파일 삭제
			 String attfileName = file.getFile_upname();
			 int ret = fService.delete(attfileName);
			 
			 if(ret>0) {
				 fDao.delete(file.getFile_seq());
			 }
			 
			// 데이터 한개씩 삭제
			
		}
//		본문 첨부파일 삭제
		String imgFileName = gaDTO.getG_image();
		int ret = fService.delete(imgFileName);
		
//		본문데이터 삭제
//		 gaDao.delete(g_seq);
		if(ret > 0) {
			//본문 데이터 삭제
			gaDao.delete(g_seq);
			
		} else {
			log.debug("파일 삭제 실패로 데이터 삭제하지않음");
		}
		
		return 1;
	}


}
