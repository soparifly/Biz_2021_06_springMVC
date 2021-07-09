package com.team.starbucks.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.MultipartFile;

import com.team.starbucks.service.FileService;

public class FileServiceImplV1 implements FileService{

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		String orinalFileName = file.getOriginalFilename();
		if(orinalFileName.isEmpty()) {
			return null;
		}
		
		
		
		
		
		
		return null;
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
