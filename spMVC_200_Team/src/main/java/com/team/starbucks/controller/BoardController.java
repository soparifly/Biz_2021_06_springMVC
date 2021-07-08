package com.team.starbucks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.team.starbucks.model.BoardDTO;
import com.team.starbucks.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.val;
@RequiredArgsConstructor
@RequestMapping(value = "/board")
@Controller
public class BoardController {
	
	@Qualifier("boardServiceV1")
	protected final BoardService bdService;
	
	@RequestMapping(value = {"","/"}, method= RequestMethod.GET)
	public String selectAll(Model model) {
		List<BoardDTO> bdList = bdService.selectAll();
		model.addAttribute("BOARD_LIST", bdList);
		return "board/list";
	}
	
//	public String insert(@RequestParam("")) {
//		
//		
//	}
}