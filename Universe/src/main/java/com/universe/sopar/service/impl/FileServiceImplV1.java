package com.universe.sopar.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.universe.sopar.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService{

	protected final String winPath;
	protected final String macPath;
	
	protected String fileUpPath;

	@Autowired
	public void getFilePath(String winPath, String macPath) {
		this.fileUpPath = this.winPath;
	}
	
	
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO file업로드 기능
		
		String originalFileName = file.getOriginalFilename();
		
		if(originalFileName == null || originalFileName.isEmpty()) {
			return "";
		}
		File path = new File(macPath);
		
		if(path.exists()) {
			this.fileUpPath = this.macPath;
		}

		path = new File(fileUpPath);
		if(!path.exists()) {
			path.mkdirs();
		}
		
		String strUUID = UUID.randomUUID().toString();
		strUUID += originalFileName;
		
		File uploadPathAndFile = new File(fileUpPath, strUUID);
		file.transferTo(uploadPathAndFile);
		return strUUID;
	}
	public int delete(String imgFileName) {
		if(imgFileName == null || imgFileName.isEmpty()) {
			return 1;
		}
		File deleteFile = new File(this.fileUpPath, imgFileName);
		
		if(deleteFile.exists()) {
			boolean ok = deleteFile.delete();
			if(ok) { 
				log.debug("파일삭제");
			} else {
				log.debug("파일삭제실패");
				return -1;
			}
			
		}
		return 1;
	}
}
