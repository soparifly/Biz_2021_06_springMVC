package com.callor.gallery.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.FileDTO;
import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.model.PageDTO;
import com.callor.gallery.persistance.ext.FileDao;
import com.callor.gallery.persistance.ext.GalleryDao;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.GalleryService;
import com.callor.gallery.service.PageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * final로 선언된 Inject 변수의 초기화를 시키는데 필요한 
 * 생성자를 자동으로 만들어주는 lombok의 기능이다.
 * 
 * 클래스를 상속하면  @RequieredArgsConstructor는 
 * 상속받은 클래스에서 사용이 불가능하다
 * 
 */
@RequiredArgsConstructor
@Slf4j
@Service("gallerySerivceV1")
public class GalleryServiceImplV1 implements GalleryService {

	protected final GalleryDao gaDao;
	protected final FileDao fDao;

	@Qualifier("fileServiceV2")
	protected final FileService fService;

	protected final PageService pageService;

	/*
	 * @Autowired를 이용한 트릭 
	 *
	 *	프로그램 작동시 자동으로 테이블을 만들게함
	 *	@autowired가 설정된 변수, 함수, 객체등을 만나면
	 *	Sprign frameword는 변수를 최고하, 함수를 실행하여 또 변수초기화
	 *	이미 생성되어 준비된 객체 주입등을 수행한다
	 */
	//	@Autowired            //경고가나오기때문에 실제로ㅓ 필요없는 메서드를 입력한다 
	//	public void create_table(GalleryDao gDao) {
	//		
	//		Map<String,String> maps = new HashMap<String,String>();
	//		gaDao.create_table(maps);
	//		fDao.create_table(maps);
	//		
	//	}

	@Override
	public int insert(GalleryDTO galleryDTO) throws Exception {
		// TODO 보류
		return 0;
	}

	@Override
	public void input(GalleryDTO gaDTO, MultipartFile one_file, MultipartHttpServletRequest m_file) throws Exception {
		//		대표이미지가 업로드되면...
		//		이미지를 서버에 저장하고
		//		저장된 파일의 이름을 return 받기
		String strUUID = fService.fileUp(one_file);

		//		DTO에 이미지이름을 저장하기
		gaDTO.setG_image(strUUID);
		log.debug("INSERT 전 seqw{} ", gaDTO.getG_seq());

		//		GalleryDTO에 담긴 데이터를 tbl_gallery table 에 insert 하기
		gaDao.insert(gaDTO);

		//		insert후 gDTO seq 의 값확인하
		log.debug("INSERT 후 seqw{} ", gaDTO.getG_seq());
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
		for (MultipartFile file : mfiles) {

			String fileOriginName = file.getOriginalFilename();
			String fileUUName = fService.fileUp(file);

			FileDTO fDto = FileDTO.builder().file_gseq(g_seq) //갤러리 데이터의 PK값
					.file_original(fileOriginName).file_upname(fileUUName).build();
			files.add(fDto);
		}
		log.debug("이미지들 {}", files.toString());
		fDao.insertOrUpdateWithList(files);
	}

	@Override
	public List<GalleryDTO> selectAll() {
		// TODO Auto-generated method stub

		List<GalleryDTO> gaList = gaDao.selectAll();
		//		log.debug("갤러리 리스트 {} ",gaList.toString());
		return gaList;
	}

	@Override
	public List<GalleryFilesDTO> findByIdGalleryFiles(Long g_seq) throws Exception {

		List<GalleryFilesDTO> gfList = gaDao.findByIdGalleryFiles(g_seq);

		/*
		 * dao로 부터 select를 한 후 데이터 검증 하기 위해 사용하는 코드
		 * gfList가 데이터가 조회되지 않아 null이 발생할수 있다
		 */
		if (gfList != null && gfList.size() > 0) {
			log.debug(gfList.toString());
		} else {
			log.debug("조회된 데이터가 없음");
		}

		return gfList;
	}

	@Override
	public GalleryDTO findByIdGallery(Long g_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long g_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int file_delete(Long g_seq) {
		// TODO Auto-generated method stub

		//		파일을 삭제하기위하여 저장된 파일 정보를 SELECT하기		
		FileDTO fDTO = fDao.findById(g_seq);
		//		업로드되어 저장된파일을 삭제
		int ret = fService.delete(fDTO.getFile_upname());
		if (ret > 0) {
			//			mysql 에서 tbl_files의 데이터목록에서 삭제하기
			fDao.delete(g_seq);
		}

		return 0;
	}

	@Override
	public List<GalleryDTO> selectAllPage(int pageNum) throws Exception {
		/*
		 *  TODO
		 *  pageNum를 매개변수로 받아서 
		 *  selectAll 한 데이트를 잘라내고
		 *  pageNum에 해당하는 list부분만 return 하기
		 *  
		 *   한페이지에 보여줄 list = 10개
		 */
		//		1 전체 데이터 select 하기 
		List<GalleryDTO> gaListAll = gaDao.selectAll();
		//		2. page Num 1이라면 list 에서 0 ~ 9(10개) 요소까지 추출하기
		//			만약 page가 2라면 list에서 10~ 19번째까지 요소 추출하기 
		//			만약 page가 3라면 list에서 20~ 29번째까지 요소 추출하기 
		int totalCount = gaListAll.size();

		int start = (pageNum - 1) * 10;
		int end = pageNum * 10;

		if (pageNum * 10 > totalCount - 10) {
			end = totalCount;
			start = end - 10;
		}

		List<GalleryDTO> pageList = new ArrayList<>();
		for (int i = start; i < end; i++) {
			pageList.add(gaListAll.get(i));
		}
		return pageList;
	}

	@Override
	public List<GalleryDTO> selectAllPage(int intPageNum, Model model) throws Exception {
		List<GalleryDTO> galleryAll = gaDao.selectAll();
		int totalListSize = galleryAll.size();

		PageDTO pageDTO = pageService.makePagination(totalListSize, intPageNum);
		List<GalleryDTO> pageList = new ArrayList<GalleryDTO>();
		for (int i = pageDTO.getOffset(); i < pageDTO.getLimit(); i++) {
			pageList.add(galleryAll.get(i));
		}
		model.addAttribute("PAGE_NAV", pageDTO);
		model.addAttribute("GALLERYS", pageList);
		return null;
	}

	@Override
	public List<GalleryDTO> findBySearchOrderPage(int pageNum, String search, String column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GalleryDTO> findBySearchPage(String search_column, String search_text, int pageNum, Model model) {
		// TODO Auto-generated method stub
		List<GalleryDTO> galleryList = gaDao.findBySearch(search_column, search_text);

		int totalListSize = galleryList.size();
		PageDTO pageDTO = pageService.makePagination(totalListSize, pageNum);
		List<GalleryDTO> pageList = new ArrayList<GalleryDTO>();
		if(pageDTO ==null) {
			model.addAttribute("GALLERY", galleryList);
			return null;
		}
		for (int i = pageDTO.getOffset(); i < pageDTO.getLimit(); i++) {
			pageList.add(galleryList.get(i));
		}

		model.addAttribute("GALLERYS", galleryList);

		return null;
	}

}
