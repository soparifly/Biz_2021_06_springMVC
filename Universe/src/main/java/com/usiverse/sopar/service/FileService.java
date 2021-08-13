package com.usiverse.sopar.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public String fileUp(MultipartFile one_file) throws Exception;
	
}
