package com.callor.gallery.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.FileDTO;
import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.persistance.ext.FileDao;
import com.callor.gallery.persistance.ext.GalleryDao;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service("gallerySerivceV1")
public class GalleryServiceImplV1 implements GalleryService{

	
	protected final GalleryDao gaDao;
	protected final FileDao fDao;
	
	
	@Qualifier("fileServiceV2")
	protected final FileService fService;
	
	/*
	 * @Autowired를 이용한 트릭 
	 *
	 *	프로그램 작동시 자동으로 테이블을 만들게함
	 *	@autowired가 설정된 변수, 함수, 객체등을 만나면
	 *	Sprign frameword는 변수를 최고하, 함수를 실행하여 또 변수초기화
	 *	이미 생성되어 준비된 객체 주입등을 수행한다
	 */
	@Autowired            //경고가나오기때문에 실제로ㅓ 필요없는 메서드를 입력한다 
	public void create_table(GalleryDao gDao) {
		
		Map<String,String> maps = new HashMap<String,String>();
		gaDao.create_table(maps);
		fDao.create_table(maps);
		
	}
	
	@Override
	public int insert(GalleryDTO galleryDTO) throws Exception {
		// TODO 보류
		return 0;
	}

	@Override
	public void input(GalleryDTO gaDTO, MultipartFile one_file, MultipartHttpServletRequest m_file) throws Exception {
		// TODO Auto-generated method stub

		//대표이미지가 업로드되면...
//		이미지를 서버에 저장하고
//		저장된 파일의 이름을 return 받기
		
		String strUUID = fService.fileUp(one_file);
		
//		DTO에 이미지이름을 저장하기
		gaDTO.setG_image(strUUID);
		log.debug("INSERT 전 seqw{} ",gaDTO.getG_seq());
			
//		GalleryDTO에 담긴 데이터를 tbl_gallery table 에 insert 하기
		gaDao.insert(gaDTO);
//		insert후 gDTO seq 의 값확인하
		log.debug("INSERT 후 seqw{} ",gaDTO.getG_seq());
		/*
		 * mapper에서 insert를 수행한 후 새로 생성된 g_seq값을
		 * selectKey 하여 gaDTO의g_seq 변수에 담아놓은 상태이다
		 */
		
		
//		갤러리 게시판 seq값과 파일들 묶음으로 insert 하기 위한 준비하기
		Long g_seq = gaDTO.getG_seq();
		
		
		
		List<FileDTO> files = new ArrayList<FileDTO>();
		
//		업로드된 멀티파일을 서버에 업로드 하고 
//		원래 파일이름과 UUID가 첨가된 파일이름 추출하여 fileDTO에 담고 
//		다시 List에 담아놓는다 
//		파일업로드 구조
		List<MultipartFile> mfiles = m_file.getFiles("m_file");
		for(MultipartFile file : mfiles) {
			
			String fileOriginName =file.getOriginalFilename();
			String fileUUName = fService.fileUp(file);
			
			FileDTO fDto = FileDTO.builder()
					.file_gseq(g_seq) //갤러리 데이터의 PK값
					.file_original(fileOriginName)
					.file_upname(fileUUName)
					.build();
			files.add(fDto);
		}
		log.debug("이미지들 {}", files.toString());
		fDao.insertOrUpdateWithList(files);
	}
	@Override
	public List<GalleryDTO> selectAll() {
		// TODO Auto-generated method stub
		
		List<GalleryDTO> gaList = gaDao.selectAll();
		log.debug("갤러리 리스트 {} ",gaList.toString());
		return gaList;
	}

	@Override
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq) throws Exception {
		// TODO Auto-generated method stub
//		return null;
		return gaDao.findByIdGalleryFiles(g_seq);
	}


}
