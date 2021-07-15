package com.callor.gallery.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("fileServiceV2")
public class FileServiceImplV2 extends FileServiceImplV1 {

	//	 file - context.xml에 설정된 변수값 가져오기
	protected final String winPath;
	protected final String macPath;
	protected String fileUpPath;

	@Autowired
	public void getFilePath(String winPath, String macPath) {
		// TODO Auto-generated method stub
		/*
		 * 파일을 업로드할때 사용할 경로(Path)를 가져오기
		 *	먼저 지정된 폴더를 윈도우 기반으로 설정을 한다
		 *
		 *1.지정된 폴더를 윈도우 기반의 폴더로 설정
		 *2. mac기반의 폴더가 있으면 해당 폴더로 변경
		 */
		this.fileUpPath = this.winPath;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		String originFileName = file.getOriginalFilename();
		if (originFileName == null || originFileName.isEmpty()) {
			return "";
		}

		//				현재 시스템에 macPath로 설정된 폴더가 있는지 확인하고있으면
		//				업로드 폴더를 MacPat에 지정된 값으로 설정하기
		File path = new File(macPath);
		if (path.exists()) {
			this.fileUpPath = this.macPath;
		}

		//		다시한번 fileUpPath가 있는지 검사
		//			winPath일경우는 폴더를 만들어라
		path = new File(fileUpPath);
		if (!path.exists()) {
			path.mkdirs();
		}

		String strUUID = UUID.randomUUID().toString();
		strUUID += originFileName;

		File uploadPathAndFile = new File(fileUpPath, strUUID);

		file.transferTo(uploadPathAndFile);

		return strUUID;
	}

	/*
	 * 전달받은 파일이름으로 지정된 파일을
	 * fileUppath에 저장된 파일을 삭제
	 * 
	 */
	@Override
	public int delete(String imgFileName) {
		// 삭제하기 위한 파일 정보 객체 생성

		/*
		 * fileService.delete(파일명)을 호출할때 
		 * 파일명이 null 이거나 없으면 진행을 멈추는 코드
		 * 이러한코드는 호출하는 곳에서
		 * if(파일명 == null||파일명.isEmpty()){
		 * fileService.delete(파일명)
		 * }
		 * 처럼 호출할 수 있지만
		 * delete() method 사용하는 곳이 여러 곳 이라면
		 * 그때마다 검사하는 코드를 부착해야한다
		 * 그것보다는 딜리트 메소드가 시작될때 
		 * 파일의 널값등을 검사하여 실행을 취소하는 방법이 더 편리한 코드가 될것이다 
		 */

		if (imgFileName == null || imgFileName.isEmpty()) {
			return 1;
		}
		File delFile = new File(this.fileUpPath, imgFileName);
		if (delFile.exists()) {
			boolean ok = delFile.delete();
			if (ok) {
				log.debug("파일삭제 성공");
				return 1;
			} else {
				log.debug("파일 삭제 실패");
				/*
				 * method return type을 wapper class(Integer, Long)등으로 설정하면
				 * 실패하는 메시지를 return 을 null을 return 하면된다
				 * 
				 * 반면에
				 * primitive 숫자형으로 return type 을 설정한경우
				 * null 값을 사용할 수 없기 때문에 
				 * 성공한 메시지는 양의 정수값을 return 하고 
				 * 실패한 메시지는 음의 정수값을 return한다
				 * 
				 * 호출 한 곳에서 성공 실패를 검사 할때, if (return > 0  ) 성공
				 * if(return <0 )실패 와 같은 방식을 사용할 수 있다.
				 */
				return -1;
			}

		}
		return 0;
	}
}
