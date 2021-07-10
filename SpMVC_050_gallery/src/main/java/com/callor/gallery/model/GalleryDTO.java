package com.callor.gallery.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GalleryDTO {

	/*
	 * 사진 갤러리 게시판을 만들기 위해서 Content를 저장할 table 구조의 DTO를 생성하기
	 */
	private Long g_seq; //PK, 자동완성(설정)
	private String g_writer; //작성자
	private String g_date; //작성일자
	private String g_time; //작성시각
	private String g_subject; //제목
	private String g_content; //내용
	private String g_image; //사진갤러리의 대표이미지

	//	Gallery와 연고나된 파일리스트를 담을 리스트 타입의 변수추
	// mapper에서 Collerction으로 채울데이
	List<FileDTO> fileList;
}
