package com.callor.gallery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.model.MemberVO;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/gallery")
public class GalleryController {
	@Qualifier("galleryServiceV2")
	protected final GalleryService gaService;

	/*
	 * localhost:8080/rootPath/gallery/dumy로 요청할때 Request가 처리한다 
	 * 1 . a tag를 클릭했을때
	 * <a href="${rootPath}/gallery/dumy>열기</a>
	 * 2.	JS
	 * location.href="${rootPath}/gallery/dumy"가 실행됫을때
	 * 
	 */
	@RequestMapping(value = "/dumy", method = RequestMethod.GET)
	public String dumy() {
		return "home";

	}

	/*
	 * JSP에서 <form action="${rootPath}/dumy" emthod=POST>
	 * 			<button></button>
	 */
	@RequestMapping(value = "/dumy", method = RequestMethod.POST)
	public String dumy(String str) {

		return "home";
	}
	/*
	 * localhost:8080/rootPath/gallery또는 
	 * localhost:8080/rootPath/gallery/ 로 요청했을
	 */

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String list(Model model,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "search_column", required = false, defaultValue = "NONE") String search_column,
			@RequestParam(value = "search_text", required = false, defaultValue = "NONE") String search_text)
			throws Exception {
		
		
		int intPageNum = Integer.valueOf(pageNum);
		
		List<GalleryDTO> gaList = gaService.selectAllPage(intPageNum);

		//List<GalleryDTO> gaList = gaService.selectAll();

		if (intPageNum > 0) {
			model.addAttribute("PAGE_NUM", intPageNum);
		}

		//tbl_gallery table 전체 갯수 (리스트)를 가져와서
		//전체 list를 표시하기 위해서 몇페이지의 nav가
		// 필요한지 확인함
		List<GalleryDTO> listCount = gaService.selectAllPage(intPageNum, model);

//		model.addAttribute("GALLERYS", gaList);
		model.addAttribute("BODY", "GA-LIST");

		
		
//		search_column, search_text를 사용하여 조건검색
		gaService.findBySearchPage(search_column, search_text,pageNum,model);
		
		
		
		
		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model, HttpSession session) {
		MemberVO memVO = (MemberVO) session.getAttribute("MEMBER");
		if (memVO == null) {
			return "redirect:/member/login";
		}

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");

		String curDate = sd.format(date);
		String curTime = st.format(date);

		GalleryDTO gaDTO = GalleryDTO.builder().g_date(curDate).g_time(curTime).g_writer("sopar").build();

		model.addAttribute("CMD", gaDTO);
		model.addAttribute("BODY", "GA-INPUT");
		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(GalleryDTO gaDTO, MultipartFile one_file, MultipartHttpServletRequest m_file, Model model)
			throws Exception {

		log.debug("갤러리 정보 {} ", gaDTO.toString());
		log.debug("single file {} ", one_file.getOriginalFilename());
		log.debug("멀티파일 {} ", m_file.getFileMap().toString());

		gaService.input(gaDTO, one_file, m_file);

		return "redirect:/gallery";

	}

	@RequestMapping(value = "/detail/{seq}", method = RequestMethod.GET)
	public String detail( //PathVariable어디서 날아오는지 물어보
			@PathVariable("seq") String seq, Model model) throws Exception {
		Long g_seq = 0L;

		try {
			g_seq = Long.valueOf(seq);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/gallery";
		}
		List<GalleryFilesDTO> gfList = gaService.findByIdGalleryFiles(g_seq);

		model.addAttribute("GFLIST", gfList);
		model.addAttribute("BODY", "GA-DETAIL");

		return "home";
	}

	@RequestMapping(value = "/detail2/{seq}", method = RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model, HttpSession session) {
		Long g_seq = 0L;

		try {
			g_seq = Long.valueOf(seq);
		} catch (Exception e) {
			log.debug("갤러리 ID값 오류");

			return "redirect:/";
		}
		GalleryDTO galleryDTO = gaService.findByIdGallery(g_seq);
		model.addAttribute("GALLERY", galleryDTO);
		model.addAttribute("BODY", "GA-DETAIL-V2");
		return "home";
	}

	/*
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("g_seq") String seq, HttpSession session) {
		/*
		 * 삭제를 요구하면
		 * 1. 로그인이 되었나 확인
		 * 2. 
		 */
		MemberVO memVO = (MemberVO) session.getAttribute("MEMBER");
		if (memVO == null) {

			return "redirect:/member/login";

		}
		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);

		} catch (Exception e) {
			// TODO: handle exception
			log.debug("갤러리SEQ 오류");
			return "redirect:/gallery";
		}
		int ret = gaService.delete(g_seq);
		return "redirect:/gallery";

	}

	/*
	 * 원래라면 view 폴더에 OK.jsp를 찾아서 보내줘야하고 이과정에서 404 오류가 발생한다
	 * 하지만 어노테이션 ResponseBody를 달아주면 문자열 값인 "OK"를 응답한
	 */
	@ResponseBody
	@RequestMapping(value = "/file/delete/{seq}", method = RequestMethod.GET)
	public String file_delete(@PathVariable("seq") String seq) {

		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return "FAIL_SEQ";

		}
		int ret = gaService.file_delete(g_seq);
		if (ret > 0)
			return "OK";
		else
			return "FAIL";
	}
}
