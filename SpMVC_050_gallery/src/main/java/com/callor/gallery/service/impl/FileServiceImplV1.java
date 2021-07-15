package com.callor.gallery.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService {

//	protected final ServletContext context;
	@Autowired
	private ResourceLoader resLoader;

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		//		파일정보에서 파일이름 추출하기

		String originalFileName = file.getOriginalFilename();
		//		파일 이름이 비어있으면 null 을 return 
		if (originalFileName.isEmpty()) {
			return null;
		}
		//     context.xml에 설정된 files 정보를 가져오기
		Resource res = resLoader.getResource("/files");
		//		file-context.xml에 설정된

		//		file 폴더 정보를 가져오기 
		//		d여기에 파일을 uploa저장할 예
		//		log.debug ("path : {}",res.getURI().getPath());

		//		 ~~~/Project/files
		String filePath = res.getURI().getPath();

		String strUUID = UUID.randomUUID().toString();
		strUUID += originalFileName;

		/*
		 * 파일을 업로드할때 보안주의하기
		 * 실제 파일이름으로 업로드 수행하면
		 * 쉽게 업로드 구현이 된다
		 * 하지만 
		 * 
		 * 만약 같은 이름의 파일을 중복해서 업로드하면 먼저 업로드된 파일이변경되는 문제가 발쌩한다
		 * 해커에 의해서 같은 파일의 이름으로파일들을 업로드 해버리면 저장된 원래 파일들이 
		 * 모두 변조될수있다
		 * 이러한 문제를 방지하기 위하여 
		 * UUID문자열을 생성하고 ,UUID + 원래파일이름.원래확장자 형식으로 업로드를 수행한
		 * 이런방식으로 파일을 저장하면 해킹의 위험을 다소막을수 ㅣㅇㅆ다.
		 * 
		 */

		//			실제 업로드할 Path와 파일이름을 + 하여 업로드 준비
		//		/file + "/" + originalFileName	
		File uploadPathAndFile = new File(filePath, strUUID);

		// file에 담간 파일 정보를 사용하여 
		// uploadPathAndFile에 전송하라(복사하라, 업로드하라);
		file.transferTo(uploadPathAndFile);

		return strUUID;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub

		List<String> fileNames = new ArrayList<String>();
		//		String tagName = files.getFileNames();
		String tagName = "m_file";
		List<MultipartFile> fileList = files.getFiles(tagName);
		for (MultipartFile file : fileList) {
			String fileName = this.fileUp(file);
			fileNames.add(fileName);
		}
		return fileNames;
	}

	@Override
	public int delete(String imgFileName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
