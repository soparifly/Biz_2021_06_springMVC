package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService{
//	1개의 파일을 업로드하고 업로드한 파일이름을 return  
	public String fileUp(MultipartFile file) throws Exception;
	
//	다수의 파일을 업로드하고 파일 이름들을 retrun 
	public List<String> filesUp(MultipartHttpServletRequest files)throws Exception ;
	
}