package com.universe.sopar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.universe.sopar.model.GalleryDTO;
import com.universe.sopar.model.GalleryFilesDTO;
import com.universe.sopar.service.AstroService;
import com.universe.sopar.service.FileService;
import com.universe.sopar.service.GalleryService;
import com.universe.sopar.service.impl.AstroInfoEventImplV1;
import com.universe.sopar.service.impl.FileServiceImplV1;
import com.universe.sopar.service.impl.GalleryServiceImplV1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {
	
	@Qualifier("astroServiceV1")
	protected final AstroService astService;
	
	@Qualifier("fileServiceV1")
	protected final FileService fService;
	
	@Qualifier("galleryServiceImplV1")
	protected final GalleryService gService;
	
	

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String testhome(Model model) throws Exception {

		List<GalleryDTO> gList = gService.selectAll();
		log.debug("갤러리 불러옴 {}", gList.toString());
		model.addAttribute("GALLERY", gList);
		
		return "home";
	}
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.POST)
	public String home(Model model, GalleryDTO galleryDTO, MultipartFile one_file, MultipartHttpServletRequest multi_file) throws Exception {
		
		log.debug("gallery input {} ", galleryDTO.toString());
		
		log.debug("one_file name {} ", one_file.getOriginalFilename());
		
		log.debug("multi_file name {} " , multi_file.getFileMap().toString());
		
		gService.input(galleryDTO, one_file, multi_file);
		
		return "redirect:/";
	}
	
}
