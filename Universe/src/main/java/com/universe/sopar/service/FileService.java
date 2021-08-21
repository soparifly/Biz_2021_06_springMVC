package com.universe.sopar.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public String fileUp(MultipartFile one_file) throws Exception;

	public int delete(String file_upName);
	
}
