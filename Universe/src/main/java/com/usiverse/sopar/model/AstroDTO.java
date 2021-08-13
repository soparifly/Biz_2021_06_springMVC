package com.usiverse.sopar.model;

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
public class AstroDTO {

	private String resultCode;	//		결과코드		필수	00	00:성공
	private String resultMag;	//	 	결과메시지		필수	NORMAL SERVICE	결과 메시지
	private String locdate;		//		날짜	8		필수	20170901	날짜
	private String seq;			// 		순번	1		필수	1	같은날짜의 두 개 이상의 데이터가 있을경우 카운팅함
	private String astroTitle;	//		천문현상명	100	필수	대형광학망원경 개발 및 은하진화 연구	천문현상 명
	private String astroTime;	//		천문현상 시간	20	필수	6:00	천문현상 시간
	private String astroEvent;	//		천문현상	500	필수	지구 근일점(0.983290A.U.)	천문현상에 대한 내용
	private String remarks;		//		비고	100	옵션		비고
	private String numOfRows;	//		페이지당항목수	필수	1	
	private String pageNo;		//		페이지수		필수	10	
	private String totalCount;	//		모든항목수		필수	16	


}
